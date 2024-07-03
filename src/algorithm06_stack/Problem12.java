package algorithm06_stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem12 {

    /**
     * @문제12
     * 초 단위로 기록된 주식 가격이 담긴 배열 prices 가 매개변수로 주어질 때,
     * 가격이 떨어지지 않은 기간은 몇 초인지 반환하도록 solution() 함수를 완성하세요.
     * @제약조건
     * 1. prices 의 각 가격은 1 이상 10,000 이하인 자연수
     * 2. prices 의 길이는 2 이상 100,000 이하
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        int[] prices = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            prices[i] = scanner.nextInt();
        }

        int[] result = solution(prices);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }
        return answer;
    }
}
