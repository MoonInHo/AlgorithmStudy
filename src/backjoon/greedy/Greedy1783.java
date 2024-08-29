package backjoon.greedy;

import java.util.Scanner;

public class Greedy1783 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(min((M + 1) / 2));
        } else if (M < 7) {
            System.out.println(min(M));
        } else {
            System.out.println(M - 7 + 5);
        }
    }

    private static int min(int b) {
        return Math.min(4, b);
    }
}
