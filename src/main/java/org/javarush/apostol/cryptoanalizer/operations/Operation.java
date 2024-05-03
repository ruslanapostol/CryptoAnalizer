package org.javarush.apostol.cryptoanalizer.operations;


import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public abstract class Operation {
    protected Caesar caesar;
    protected ConsoleView view;
    protected String inputFileName;
    protected String outputFileName;
    protected int key;

    public Operation(Caesar caesar, ConsoleView view, String inputFileName,
                     String outputFileName, int key) {
        this.caesar = caesar;
        this.view = view;
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.key = key;
    }

    public abstract void execute();

    public String getOutputFileName() {
        return outputFileName;
    }
}

