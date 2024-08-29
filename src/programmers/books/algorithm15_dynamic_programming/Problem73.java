package programmers.books.algorithm15_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem73 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int landLength = scanner.nextInt();
        int[][] land = new int[landLength][4];

        for (int i = 0; i < landLength; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {

                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, land[i - 1][k]);
                    }
                }
                land[i][j] += max;
            }
        }
        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}
