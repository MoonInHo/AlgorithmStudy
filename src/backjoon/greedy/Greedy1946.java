package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];

            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(str[0]);
                arr[j][1] = Integer.parseInt(str[1]);
            }

            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int top = arr[0][1];
            int count = 0;

            for (int j = 1; j < N; j++) {
                if (top < arr[j][1]) {
                    count++;
                    continue;
                }
                top = arr[j][1];
            }
            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }
}