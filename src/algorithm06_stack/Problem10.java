package algorithm06_stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Problem10 {

    /**
     * @문제10
     * 올바른 문자열의 정의
     * - "()", "[]", "{}" 는 모두 올바른 괄호 문자열
     * - 만약 A가 올바른 괄호 문자열이라면, "(A)", "[A]", "{A}"도 올바른 괄호 문자열
     *   -> "[]" 가 올바른 괄호 문자열 이므로 "([])" 도 올바른 괄호 문자열
     * - 만약 A, B 가 올바른 괄호 문자열이라면, AB도 올바른 괄호 문자열
     *   -> "{}" 와 "([])" 가 올바른 괄호 문자열 이므로 "{}([])"도 올바른 괄호 문자열
     * 대괄호, 중괄호 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
     * 이 s를 왼쪽으로 x(0 <= x < (s의 길이)) 칸 만큼 회전시켰을 때
     * s가 올바른 괄호 문자열이 되게 하는 x의 개수를 반환하는 solution() 함수를 완성하세요.
     * @제약조건
     * - s의 길이는 1 이상 1,000 이하
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int result = solution(s);

        System.out.println(result);
    }

    public static int solution(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length(); // 원본 문자열의 길이 저장
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌

        int answer = 0;

        A:for (int i = 0; i < n; i++) {

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + n; j++) {

                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
