package programmers.books.algorithm05_array;

import java.util.Arrays;
import java.util.Scanner;

public class Problem01 {

    /**
     * @문제1
     * 정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요
     * @제약조건
     * 1. 정수 배열의 길이는 2 이상 10^5 이하
     * 2. 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        if (arrayLength < 2 || arrayLength > 100000) {
            return;
        }

        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] < -100000 || arr[i] > 100000) {
                return;
            }
        }
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
