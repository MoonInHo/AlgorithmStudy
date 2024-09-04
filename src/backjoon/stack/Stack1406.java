package backjoon.stack;

import java.io.*;

public class Stack1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());

        int M = Integer.parseInt(br.readLine());

        int idx = sb.length();

        for (int i = 0; i < M; i++) {

            String command = br.readLine();

            switch (command) {
                case "L":
                    if (idx != 0) idx--;
                    break;
                case "D":
                    if (idx != sb.length()) idx++;
                    break;
                case "B":
                    if (idx != 0) {
                        sb.deleteCharAt(idx - 1);
                        idx--;
                    }
                    break;
                default:
                    sb.insert(idx, command.substring(2));
                    idx++;
                    break;
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
