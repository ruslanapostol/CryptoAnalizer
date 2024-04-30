package org.javarush.apostol.cryptoanalizer.model;


import java.util.*;

public class Caesar {
    private static final List<Character> ALPHABET = Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К',
            'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
            'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            '.', ',', '!', '?', ' ', '-', '"', '—'
    );

    private static final Map<Character, Integer> ALPHABET2POS = initializeAlphabetMap();

    private static Map<Character, Integer> initializeAlphabetMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ALPHABET.size(); i++) {
            map.put(ALPHABET.get(i), i + 1);
        }
        return map;
    }

    public String encrypt(String text, int key) {
        return shift(text, key);
    }

    public String decrypt(String text, int key) {
        return shift(text, -key);
    }

    private String shift(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            Integer position = ALPHABET2POS.get(Character.toUpperCase(ch));
            if (position == null) {
                result.append(ch);
            } else {
                int newPosition = (position - 1 + key) % ALPHABET.size();
                if (newPosition < 0) {
                    newPosition += ALPHABET.size();
                }
                result.append(ALPHABET.get(newPosition));
            }
        }
        return result.toString();
    }
}

