package org.javarush.apostol.cryptoanalizer.main;


public class App {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println(Constants.MSG_USAGE);
            return;
        }

        try {
            String operationType = args[0];
            String inputFileName = new PathBuilder(Constants.BASE_DIRECTORY).add(args[1]).build();
            String outputFileName = new PathBuilder(Constants.BASE_DIRECTORY).add(args[2]).build();

            Caesar caesar = new Caesar();
            ConsoleView view = new ConsoleView();
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
            // Cleanup if needed
        }
    }
}

