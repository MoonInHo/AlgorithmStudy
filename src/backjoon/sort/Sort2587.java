package backjoon.sort;

import java.io.*;
import java.util.Arrays;

public class Sort2587 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            sum += input;
        }

        Arrays.sort(arr);

        sb.append(sum / 5).append("\n");
        sb.append(arr[2]);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}