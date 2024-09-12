package backjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort10852 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Score[] scores = new Score[N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            scores[i] = new Score(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(scores, (o1, o2) -> {
            int result = o2.korean - o1.korean;
            if (result == 0) result = o1.english - o2.english;
            if (result == 0) result = o2.math - o1.math;
            if (result == 0) return o1.name.compareTo(o2.name);
            return result;
        });

        for (Score score : scores) {
            sb.append(score.name).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static class Score {

        String name;
        int korean;
        int english;
        int math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
