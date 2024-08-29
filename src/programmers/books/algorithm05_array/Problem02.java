package programmers.books.algorithm05_array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problem02 {

    /**
     * @문제2
     * 정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution 함수를 구현하세요.
     * @제약조건
     * 1. 배열 길이는 2 이상 1.000 이하입니다.
     * 2. 각 배열의 데이터 값은 -100,000 이상 100,000 이하입니다.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        if (arrayLength < 2 || arrayLength > 1000) {
            return;
        }

        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] < -100000 || arr[i] > 100000) {
                return;
            }
        }
        int[] resultArray = solution(arr);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] solution(int[] arr) {

        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
