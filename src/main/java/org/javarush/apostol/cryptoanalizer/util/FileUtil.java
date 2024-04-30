package org.javarush.apostol.cryptoanalizer.util;


import org.javarush.apostol.cryptoanalizer.exception.AppException;

import java.io.*;

public class FileUtil {

    public static String readFile(String fileName) throws AppException {
        try {
            StringBuilder result = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            }
            return result.toString();
        } catch (IOException e) {
            throw new AppException("Failed to read file: " + fileName, e);
        }
    }

    public static void writeFile(String fileName, String content) throws AppException {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(content);
            }
        } catch (IOException e) {
            throw new AppException("Failed to write file: " + fileName, e);
        }
    }
}
