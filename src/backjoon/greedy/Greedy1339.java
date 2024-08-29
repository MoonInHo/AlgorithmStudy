package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int size = s.length();
            for (int j = 0; j < size; j++) {
                char c = s.charAt(j);
                alpha[c - 'A'] += (int) Math.pow(10, size - 1 - j);
            }
        }

        Arrays.sort(alpha);

        int multipleNum = 9;
        int answer = 0;
        int idx = 25;

        while (alpha[idx] > 0) {
            answer += alpha[idx] * multipleNum;
            idx--;
            multipleNum--;
        }
        System.out.println(answer);
    }
}
