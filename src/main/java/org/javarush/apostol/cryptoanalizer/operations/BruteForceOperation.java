package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class BruteForceOperation extends Operation {

    public BruteForceOperation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        super(caesar, view, inputFileName, outputFileName);
    }

    @Override
    public void execute() {
        try {
            String content = FileUtil.readFile(inputFileName);
            for (int key = 1; key <= 40; key++) { // Adjust key range as needed
                String decrypted = caesar.decrypt(content, key);
                if (decrypted.contains(Constants.KNOWN_PLAINTEXT)) {
                    FileUtil.writeFile(outputFileName, decrypted);
                    view.displayMessage("Decryption successful with key = " + key);
                    view.displayMessage("Decrypted text saved to " + outputFileName);
                    break;
                }
            }
        } catch (AppException e) {
            view.displayError("Error: " + e.getMessage());
        }
    }
}

