package org.javarush.apostol.cryptoanalizer.main;


import org.javarush.apostol.cryptoanalizer.constants.Constants;
import org.javarush.apostol.cryptoanalizer.exception.AppException;
import org.javarush.apostol.cryptoanalizer.model.Caesar;
import org.javarush.apostol.cryptoanalizer.operations.BruteForceOperation;
import org.javarush.apostol.cryptoanalizer.operations.DecryptOperation;
import org.javarush.apostol.cryptoanalizer.operations.EncryptOperation;
import org.javarush.apostol.cryptoanalizer.operations.Operation;
import org.javarush.apostol.cryptoanalizer.util.PathBuilder;
import org.javarush.apostol.cryptoanalizer.view.ConsoleView;

public class App {
    public static void main(String[] args) {
            ConsoleView view = new ConsoleView();

        try {
            if (args.length < 3) {
                System.out.println(Constants.MSG_USAGE);
                return;
            }
            String operationType = args[0];
            String inputFileName = new PathBuilder(Constants.BASE_DIRECTORY).add(args[1]).build();
            String outputFileName = new PathBuilder(Constants.BASE_DIRECTORY).add(args[2]).build();

            Caesar caesar = new Caesar();
            Operation operation;

            switch (operationType) {
                case Constants.OPERATION_ENCRYPT:
                    operation = new EncryptOperation(caesar, view, inputFileName, outputFileName);
                    break;
                case Constants.OPERATION_DECRYPT:
                    operation = new DecryptOperation(caesar, view, inputFileName, outputFileName);
                    break;
                case Constants.OPERATION_BRUTE_FORCE:
                    operation = new BruteForceOperation(caesar, view, inputFileName, outputFileName);
                    break;
                default:
                    System.err.println(Constants.ERROR_INVALID_OPERATION);
                    return;
            }

            operation.execute();
        } catch (AppException e) {
            System.err.println("Application error: " + e.getMessage());
        } finally {
            view.close();
        }
    }
}

