package org.javarush.apostol.cryptoanalizer.constants;

public class Constants {
    public static final String OPERATION_ENCRYPT = "encrypt";
    public static final String OPERATION_DECRYPT = "decrypt";
    public static final String OPERATION_BRUTE_FORCE = "bruteforce";
    public static final String BASE_DIRECTORY = "path/to/files/";
    public static final int MIN_KEY_VALUE = 1;
    public static final int MAX_KEY_VALUE = 26;
    public static final String MSG_USAGE = "Usage: java App <operation> <inputFile> <outputFile>";
    public static final String ERROR_INVALID_OPERATION = "Invalid operation type specified.";
    public static final String KNOWN_PLAINTEXT = "КАРЛСОН";
}

