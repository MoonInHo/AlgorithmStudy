package backjoon.greedy;

import java.util.Scanner;

public class Greedy11047 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (A[i] > K) {
                continue;
            }
            count += (K/A[i]);
            K = K % A[i];
        }
        System.out.println(count);
    }
}
