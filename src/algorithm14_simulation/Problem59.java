package algorithm14_simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem59 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[][] arr = new int[arrSize][arrSize];

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int n = scanner.nextInt();

        int[][] result = solution(arr, n);

        for (int[] arrResult : result) {
            System.out.println(Arrays.toString(arrResult));
        }
    }

    private static int[][] rotate90(int[][] arr) {

        int n = arr.length;
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - i - 1] = arr[i][j];
            }
        }
        return rotatedArr;
    }

    public static int[][] solution(int[][] arr, int n) {

        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }
}
