package org.javarush.apostol.cryptoanalizer.operations;

import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class ExitOperation extends Operation {

    public ExitOperation(ConsoleView view) {
        super(null, view, null, null, 0);
    }

    @Override
    public void execute() {
        view.displayMessage("Exiting the application...");
        System.exit(0);
    }
}
