package backjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int count = 1;

        while (B != A) {
            if (B < A) {
                count = -1;
                break;
            } else if (B % 10 != 1 && B % 2 != 0) {
                count = -1;
                break;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                B /= 10;
            }
            count++;
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
