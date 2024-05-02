package org.javarush.apostol.cryptoanalizer.operations;

import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class Exit extends Operation {

    public Exit(ConsoleView view) {
        super(null, view, null, null);
    }


    @Override
    public void execute() {
        view.displayMessage("Exiting the application");
        System.exit(0);
    }
}
