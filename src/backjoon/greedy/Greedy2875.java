package backjoon.greedy;

import java.util.Scanner;

public class Greedy2875 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int count = 0;

        while (K > 0) {
            if ((M * 2) > N) {
                M--;
            } else {
                N--;
            }
            K--;
        }

        while (N >= 2 && M >= 1) {
            N -= 2;
            M--;
            count++;
        }
        System.out.println(count);
    }
}
