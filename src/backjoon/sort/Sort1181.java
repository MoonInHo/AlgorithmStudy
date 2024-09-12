package backjoon.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Sort1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> strings = new ArrayList<>(set);

        strings.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String s : strings) {
            bw.write(s + "\n");
        }
        br.close();
        bw.close();
    }
}
