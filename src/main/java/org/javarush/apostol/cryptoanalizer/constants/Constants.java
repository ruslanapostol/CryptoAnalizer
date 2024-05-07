package org.javarush.apostol.cryptoanalizer.constants;

import java.io.File;

public class Constants {
    public static final String BASE_DIRECTORY =
            System.getProperty("user.dir") + File.separator + "text" + File.separator;
    public static final int MIN_KEY_VALUE = 1;
    public static final int MAX_KEY_VALUE = 41;
    public static final String INPUT_FILE_PATH = BASE_DIRECTORY + "text.txt";
    public static final String ENCRYPTED_FILE_PATH = BASE_DIRECTORY + "encrypted_text.txt";
    public static final String DECRYPTED_FILE_PATH = BASE_DIRECTORY +  "decrypted_text.txt";
    public static final String BRUTE_FORCE_FILE_PATH = BASE_DIRECTORY +  "bruteforce_text.txt";
}

