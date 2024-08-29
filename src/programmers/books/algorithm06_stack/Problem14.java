package programmers.books.algorithm06_stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem14 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int cmdSize = scanner.nextInt();
        String[] cmd = new String[cmdSize];

        scanner.nextLine();
        for (int i = 0; i < cmdSize; i++) {
            cmd[i] = scanner.nextLine();
        }

        String result = solution(n, k, cmd);
        System.out.println(result);
    }

    public static String solution(int n, int k, String[] cmd) {

        Stack<Integer> deleted = new Stack<>();

        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        k++;

        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        char[] answer = new char[n];
        Arrays.fill(answer, '0');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }
        return new String(answer);
    }
}