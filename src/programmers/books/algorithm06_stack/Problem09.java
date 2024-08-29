package programmers.books.algorithm06_stack;

import java.util.Scanner;
import java.util.Stack;

public class Problem09 {

    /**
     * @문제9
     * 10진수를 입력받아 2진수로 변환해 반환하는 solution() 함수를 구현하세요.
     * @제약조건
     * 1. decimal 은 1이상 10억 미만의 자연수
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimal = scanner.nextInt();

        String result = solution(decimal);

        System.out.println(result);
    }

    public static String solution(int decimal) {

        Stack<Integer> binaryNumber = new Stack<>();
        while (decimal > 0) {
            binaryNumber.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!binaryNumber.isEmpty()) {
            stringBuilder.append(binaryNumber.pop());
        }
        return stringBuilder.toString();
    }
}
