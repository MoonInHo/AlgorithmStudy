package algorithm13_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Problem51 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrLength = scanner.nextInt();

        int[] arr1 = new int[arrLength];
        int[] arr2 = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < arrLength; i++) {
            arr2[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }

    public static int[] solution(int[] arr1, int[] arr2) {

        int[] merged = new int[arr1.length + arr2.length];
        int k = 0, i = 0, j = 0;

        while (i < arr1.length && j < arr1.length) {
            merged[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }
}
