package backjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy1715 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(scanner.nextInt());
        }

        long sum = 0;

        while (pq.size() > 1) {
            int value1 = pq.poll();
            int value2 = pq.poll();

            sum += value1 + value2;
            pq.add(value1 + value2);
        }
        System.out.println(sum);
    }
}
