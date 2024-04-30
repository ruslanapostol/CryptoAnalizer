package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.FileUtil;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class DecryptOperation extends Operation {

    public DecryptOperation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        super(caesar, view, inputFileName, outputFileName);
    }

    @Override
    public void execute() {
        try {
            int key = keyManager.getValidKey();
            String content = FileUtil.readFile(inputFileName);
            String decrypted = caesar.decrypt(content, key);
            FileUtil.writeFile(outputFileName, decrypted);
            view.displayMessage("Decrypted text saved to " + outputFileName);
        } catch (AppException e) {
            view.displayError("Error: " + e.getMessage());
        }
    }
}

