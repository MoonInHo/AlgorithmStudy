package programmers.books.algorithm06_stack;

import java.util.Scanner;
import java.util.Stack;

public class Problem11 {

    /**
     * @문제11
     * 알파벳 소문자로 구성된 문자열에서 같은 알파벳이 2개 붙어있는 짝을 찾고 두 문자를 제거한 뒤 앞뒤 문자를 이어붙임
     * 이 과정을 반복하여 문자열을 모두 제거하면 종료.
     * S 문자열이 주어졌을 때 성공적으로 수행 가능하면 1을, 불가능할 경우 0을 반환하는 solution() 함수를 완성하세요
     * @제약조건
     * 1. 문자열의 길이 : 1,000,000 이하의 자연수
     * 2. 문자열은 모두 소문자로 이루어져 있습니다.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int result = solution(s);

        System.out.println(result);
    }

    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
