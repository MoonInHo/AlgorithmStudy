package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Greedy1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positiveInteger = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeInteger = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {

            int value = Integer.parseInt(br.readLine());

            if (value > 0) {
                positiveInteger.add(value);
            } else {
                negativeInteger.add(value);
            }
        }

        int sum = 0;

        while (!positiveInteger.isEmpty()) {

            int num = positiveInteger.poll();

            if (positiveInteger.isEmpty()) {
                sum += num;
            } else if (positiveInteger.peek() == 1) {
                sum += num + positiveInteger.poll();
            } else {
                sum += num * positiveInteger.poll();
            }
        }

        while (!negativeInteger.isEmpty()) {

            int num = negativeInteger.poll();

            if (negativeInteger.isEmpty()) {
                sum += num;
            } else {
                sum += num * negativeInteger.poll();
            }
        }
        System.out.println(sum);
    }
}
