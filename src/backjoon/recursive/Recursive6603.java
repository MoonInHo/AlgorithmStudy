package backjoon.recursive;

import java.io.*;
import java.util.StringTokenizer;

public class Recursive6603 {

    static int[] S, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            S = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            lotto(k, 0, 0);

            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void lotto(int size, int count, int start) {
        if(count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < size; i++) {
            result[count] = S[i];
            lotto(size, count + 1, i + 1);
        }
    }
}
