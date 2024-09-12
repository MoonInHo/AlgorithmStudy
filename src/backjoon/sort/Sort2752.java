package backjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort2752 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}