package programmers.books.algorithm13_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Problem52 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stringsSize = scanner.nextInt();
        String[] strings = new String[stringsSize];

        scanner.nextLine();

        for (int i = 0; i < stringsSize; i++) {
            strings[i] = scanner.nextLine();
        }

        int n = scanner.nextInt();

        System.out.println(Arrays.toString(solution(strings, n)));
    }

    public static String[] solution(String[] strings, int n) {

        Arrays.sort(
                strings,
                (o1, o2) -> o1.charAt(n) == o2.charAt(n)
                        ? o1.compareTo(o2)
                        : Character.compare(o1.charAt(n), o2.charAt(n))
        );
        return strings;
    }
}
