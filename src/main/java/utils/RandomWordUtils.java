package utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomWordUtils {
    private static final Set<String> generatedWords = new HashSet<>();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateUniqueRandomWord(int length) {
        String word;
        do {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            word = sb.toString();
        } while (generatedWords.contains(word)); // Keep generating until unique

        generatedWords.add(word); // Store so it's not reused
        return word;
    }
}
