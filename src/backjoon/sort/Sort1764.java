package backjoon.sort;

import java.io.*;
import java.util.*;

public class Sort1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < N + M; i++) {

            String name = br.readLine();

            if (set.contains(name)) {
                result.add(name);
                continue;
            }
            set.add(name);
        }
        Collections.sort(result);
        sb.append(result.size()).append("\n");

        for (String s : result) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
