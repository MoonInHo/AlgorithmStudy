package algorithm13_sort;

import java.util.Scanner;

public class Problem50 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(solution(s));
    }

    public static String solution(String s) {

        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char) (i + 'a'));
            }
        }
        return sortedStr.toString();
    }
}
