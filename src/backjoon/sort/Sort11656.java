package backjoon.sort;

import java.io.*;
import java.util.Arrays;

public class Sort11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        String[] arr = new String[S.length()];
        arr[0] = S;

        for (int i = 1; i < S.length(); i++) {
            arr[i] = S.substring(i);
        }

        Arrays.sort(arr);

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
