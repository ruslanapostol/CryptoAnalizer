package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.util.KeyManager;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public abstract class Operation {
    protected Caesar caesar;
    protected ConsoleView view;
    protected String inputFileName;
    protected String outputFileName;
    protected KeyManager keyManager;

    public Operation(Caesar caesar, ConsoleView view, String inputFileName, String outputFileName) {
        this.caesar = caesar;
        this.view = view;
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.keyManager = new KeyManager(view);
    }

    public abstract void execute();
}

