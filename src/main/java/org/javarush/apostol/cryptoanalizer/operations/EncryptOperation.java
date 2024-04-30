package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class EncryptOperation extends Operation {

    public EncryptOperation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        super(caesar, view, inputFileName, outputFileName);
    }

    @Override
    public void execute() {
        try {
            int key = keyManager.getValidKey();
            String content = FileUtil.readFile(inputFileName);
            String encrypted = caesar.encrypt(content, key);
            FileUtil.writeFile(outputFileName, encrypted);
            view.displayMessage("Encrypted text saved to " + outputFileName);
        } catch (AppException e) {
            view.displayError("Error: " + e.getMessage());
        }
    }
}

