package backjoon.sort;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sort10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int key = Integer.parseInt(st.nextToken());

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {

            int key = Integer.parseInt(st.nextToken());

            sb.append(map.getOrDefault(key, 0)).append(" ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
