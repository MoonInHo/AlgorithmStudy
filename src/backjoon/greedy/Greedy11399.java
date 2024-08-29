package backjoon.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy11399 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        Arrays.sort(P);

        int result = 0;
        int[] tempArr = new int[N];
        tempArr[0] = P[0];

        for (int i = 1; i < N; i++) {
            tempArr[i] += tempArr[i - 1] + P[i];
        }

        for (int i : tempArr) {
            result += i;
        }
        System.out.println(result);
    }
}
