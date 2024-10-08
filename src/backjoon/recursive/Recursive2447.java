package backjoon.recursive;

import java.io.*;

public class Recursive2447 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    private static void star(int x, int y, int N, boolean blank) {

        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                star(i, j, size, count == 5);
            }
        }
    }
}
