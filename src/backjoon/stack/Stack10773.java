package backjoon.stack;

import java.io.*;
import java.util.ArrayDeque;

public class Stack10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        long sum = 0;

        for (int i : arr) {
            if (i == 0) {
                stack.pop();
                continue;
            }
            stack.push(i);
        }

        for (Integer integer : stack) {
            sum += integer;
        }
        br.close();
        System.out.println(sum);
    }
}
