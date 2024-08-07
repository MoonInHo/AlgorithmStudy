package algorithm13_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Problem58 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int phoneBookLength = scanner.nextInt();
        String[] phone_book = new String[phoneBookLength];

        scanner.nextLine();

        for (int i = 0; i < phoneBookLength; i++) {
            phone_book[i] = scanner.nextLine();
        }
        System.out.println(solution(phone_book));
    }

    private static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
