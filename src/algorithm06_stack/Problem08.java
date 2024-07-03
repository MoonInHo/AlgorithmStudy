package algorithm06_stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Problem08 {

    /**
     * @문제8
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻
     * "()()" 또는 "(())()" 는 올바른 괄호
     * ")()(" 또는 "(()(" 는 올바르지 않은 괄호
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때. 문자열 s가 올바른 괄호이면 true 아닐경우 false 를 반환하는 solution 함수를 완성
     * @제약조건
     * 1. 문자열 s의 길이 : 100,000 이하의 자연수
     * 2. 문자열 s는 '(' 또는 ')' 로만 이루어져 있음
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        boolean result = solution(s);

        System.out.println(result);
    }

    public static boolean solution(String s) {

        // 괄호의 갯수는 반드시 짝수개로 '(' 와 ')'의 갯수가 일치해야함
        // 괄호는 반드시 '(' 로 시작해야 하며 '(' 갯수보다 ')'의 갯수가 먼저 커질 수 없음
        // 스택을 활용

        if (s.charAt(0) != '(') {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Integer> roundBrackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                roundBrackets.push(1);
            } else if (s.charAt(i) == ')') {
                if (roundBrackets.isEmpty()) {
                    return false;
                }
                roundBrackets.pop();
            }
        }
        return roundBrackets.isEmpty();
    }
}
