package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class DecryptOperation extends Operation {

    public DecryptOperation(Caesar caesar, ConsoleView view,
                            String inputFileName, String outputFileName, int key) {
        super(caesar, view, inputFileName, outputFileName, key);
    }

    @Override
    public void execute() {
        try {
            String content = FileUtil.readFile(inputFileName);
            String decrypted = caesar.decrypt(content, key);
            FileUtil.writeFile(outputFileName, decrypted);
            view.displayMessage("Decryption complete. Output in " + outputFileName);
        } catch (AppException e) {
            view.displayError("Error during decryption: " + e.getMessage());
        }
    }
}

