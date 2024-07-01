package algorithm05_array;

import java.util.Arrays;
import java.util.Scanner;

public class Problem05 {

    /**
     * @문제5
     * 2차원 행렬 arr1과 arr2를 입력받아 arr1에 arr2를 곱한 결과를 반환하는 solution() 함수를 완성
     * @제약조건
     * 1. 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하
     * 2. 행렬 arr1, arr2의 데이터는 -10 이상 20 이하인 자연수
     * 3. 곱할 수 있는 배열만 주어짐
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arr1Row = scanner.nextInt();
        int arr1Column = scanner.nextInt();

        if (arr1Row < 2 || arr1Row > 100) {
            return;
        }
        if (arr1Column < 2 || arr1Column > 100) {
            return;
        }

        int arr2Row = scanner.nextInt();
        int arr2Column = scanner.nextInt();

        if (arr2Row < 2 || arr2Row > 100) {
            return;
        }
        if (arr2Column < 2 || arr2Column > 100) {
            return;
        }

        int[][] arr1 = new int[arr1Row][arr1Column];
        int[][] arr2 = new int[arr2Row][arr2Column];

        for (int i = 0; i < arr1Row; i++) {
            for (int j = 0; j < arr1Column; j++) {
                int data = scanner.nextInt();
                if (data < -10 || data > 20) {
                    return;
                }
                arr1[i][j] = data;
            }
        }

        for (int i = 0; i < arr2Row; i++) {
            for (int j = 0; j < arr2Column; j++) {
                int data = scanner.nextInt();
                if (data < -10 || data > 20) {
                    return;
                }
                arr2[i][j] = data;
            }
        }

        int[][] solution = solution(arr1, arr2);
        System.out.println(Arrays.deepToString(solution));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;

        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
