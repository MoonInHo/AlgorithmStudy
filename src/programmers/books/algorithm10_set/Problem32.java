package programmers.books.algorithm10_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem32 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int wordsSize = scanner.nextInt();
        String[] words = new String[wordsSize];

        scanner.nextLine();

        for (int i = 0; i < wordsSize; i++) {
            words[i] = scanner.nextLine();
        }

        int[] result = solution(n, words);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int n, String[] words) {

        HashSet<String> usedWords = new HashSet<>();

        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            usedWords.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }
        return new int[]{0, 0};
    }
}
