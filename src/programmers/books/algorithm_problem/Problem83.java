package programmers.books.algorithm_problem;

import java.util.Scanner;

public class Problem83 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(solution(n, m, x, y, r, c, k));
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {

        StringBuilder sb = new StringBuilder();

        int dist = k - (Math.abs(x - r) + Math.abs(y - c));

        if (dist < 0 || dist % 2 == 1) {
            return "impossible";
        }

        while (k-- > 0) {
            int[] next = getNext(n, m, x, y, r, c, k);
            x = x + next[0];
            y = y + next[1];
            sb.append((char)next[2]);
        }
        return sb.toString();
    }

    private static int[] getNext(int n, int m, int x, int y, int r, int c, int k) {
        if (x + 1 <= n && Math.abs(x + 1 - r) + Math.abs(y - c) <= k) {
            return new int[]{1, 0, 'd'};
        }
        else if (y - 1 >= 1 && Math.abs(x - r) + Math.abs(y - 1 - c) <= k) {
            return new int[]{0, -1, 'l'};
        }
        else if (y + 1 <= m && Math.abs(x - r) + Math.abs(y + 1 - c) <= k) {
            return new int[]{0, 1, 'r'};
        }
        else {
            return new int[]{-1, 0, 'u'};
        }
    }
}
