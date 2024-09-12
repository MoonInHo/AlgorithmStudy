package backjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort11651 {

    static class CoordinatePlane {

        int x;
        int y;

        public CoordinatePlane(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        CoordinatePlane[] arr = new CoordinatePlane[N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            arr[i] = new CoordinatePlane(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(arr, (o1, o2) ->  o1.y - o2.y == 0 ? o1.x - o2.x : o1.y - o2.y);

        for (CoordinatePlane c : arr) {
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
