package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class EncryptOperation extends Operation {

    public EncryptOperation(Caesar caesar, ConsoleView view, String inputFileName,
                            String outputFileName, int key) {
        super(caesar, view, inputFileName, outputFileName, key);
    }

    @Override
    public void execute() {
        try {
            String content = FileUtil.readFile(inputFileName);
            String encrypted = caesar.encrypt(content, key);
            FileUtil.writeFile(outputFileName, encrypted);
            view.displayMessage("Encrypted text saved to " + outputFileName);
        } catch (AppException e) {
            view.displayError("Error during encryption: " + e.getMessage());
        }
    }
}

