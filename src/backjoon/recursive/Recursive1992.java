package backjoon.recursive;

import java.io.*;

public class Recursive1992 {

    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {

            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        quadTree(0, 0, N);

        System.out.println(sb.toString());
    }

    private static void quadTree(int row, int col, int size) {

        if (checkQuadTree(row, col, size)) {
            if (arr[row][col] == '0') {
                sb.append("0");
            } else {
                sb.append("1");
            }
            return;
        } else {
            sb.append("(");
        }

        int newSize = size / 2;

        quadTree(row, col, newSize);
        quadTree(row, col + newSize, newSize);
        quadTree(row + newSize, col, newSize);
        quadTree(row + newSize, col + newSize, newSize);

        sb.append(")");
    }

    private static boolean checkQuadTree(int row, int col, int size) {

        char num = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != num) return false;
            }
        }
        return true;
    }
}
