package backjoon.recursive;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Recursive1780 {

    static int[][] arr;
    static HashMap<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperCount(0, 0, N);

        for (int i = 0; i < 3; i++) {
            sb.append(result.getOrDefault(i, 0)).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void paperCount(int row, int col, int size) {

        if (checkPaper(row, col, size)) {
            if (arr[row][col] == -1) {
                result.put(0, result.getOrDefault(0, 0) + 1);
            } else if (arr[row][col] == 0) {
                result.put(1, result.getOrDefault(1, 0) + 1);
            } else {
                result.put(2, result.getOrDefault(2, 0) + 1);
            }
            return;
        }

        int newSize = size / 3;

        paperCount(row, col, newSize);
        paperCount(row, col + newSize, newSize);
        paperCount(row, col + newSize * 2, newSize);

        paperCount(row + newSize, col, newSize);
        paperCount(row + newSize, col + newSize, newSize);
        paperCount(row + newSize, col + newSize * 2, newSize);

        paperCount(row + newSize * 2, col, newSize);
        paperCount(row + newSize * 2, col + newSize, newSize);
        paperCount(row + newSize * 2, col + newSize * 2, newSize);
    }

    private static boolean checkPaper(int row, int col, int size) {

        int paper = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper != arr[i][j]) return false;
            }
        }
        return true;
    }
}
