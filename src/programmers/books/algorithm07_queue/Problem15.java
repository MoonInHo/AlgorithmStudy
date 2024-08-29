package programmers.books.algorithm07_queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem15 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int result = solution(N, K);
        System.out.println(result);
    }

    private static int solution(int N, int K) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }
        return deque.pollFirst();
    }
}
