package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

import java.util.List;


public class BruteForceOperation extends Operation {

    public BruteForceOperation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        super(caesar, view, inputFileName, outputFileName, 0);
    }

    @Override
    public void execute() {
        String content = FileUtil.readFile(inputFileName);
        int bestKey = findBestKeyUsingChar(content);
        String decrypted = caesar.decrypt(content, bestKey);
        FileUtil.writeFile(outputFileName, decrypted);
        view.displayMessage("Decryption complete using key = " + bestKey + ". Output in " + outputFileName);
    }

    private int findBestKeyUsingChar(String content) {
        int bestKey = 0;
        int maxCharCount = 0;
        List<Character> alphabet = Caesar.getAlphabet();

        for (int key = Constants.MIN_KEY_VALUE; key < Constants.MAX_KEY_VALUE; key++) {
            int charCount = countCharInFileWithKey(content, key, alphabet);
            if (charCount > maxCharCount) {
                maxCharCount = charCount;
                bestKey = key;
            }
        }
        return bestKey;
    }

    private int countCharInFileWithKey(String content, int key, List<Character> alphabet) {
        int charCount = 0;

        for (char ch : content.toCharArray()) {
            int decodedIndex = (alphabet.indexOf(ch) - key + alphabet.size()) % alphabet.size();
            if (alphabet.get(decodedIndex) == ' ') {
                charCount++;
            }
        }
        return charCount;
    }
}

