package algorithm05_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem03 {

    /**
     * @문제3
     * 정수 배열 numbers 가 주어집니다.
     * numbers에서 서로 다른 인덱스에 있는 2개의 수를 뽑아 더해 만들 수 있는 모든 수를
     * 배열에 오름차순으로 담아 반환하는 solution() 함수를 완성하세요.
     * @제약조건
     * 1. numbers의 길이는 2 이상 100 이하입니다.
     * 2. numbers의 모든 수는 0 이상 100 이하입니다.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        if (arrayLength < 2 || arrayLength > 100) {
            return;
        }

        int[] numbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = scanner.nextInt();
            if (numbers[i] < 0 || numbers[i] > 100) {
                return;
            }
        }
        int[] resultArray = solution(numbers);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] solution(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                result.add(numbers[i] + numbers[j]);
            }
        }

        int[] resultArray = result.stream().distinct().mapToInt(Integer::intValue).toArray();
        Arrays.sort(resultArray);

        return resultArray;
    }
}
