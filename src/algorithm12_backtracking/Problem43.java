package algorithm12_backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem43 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        System.out.println(solution(N));
    }

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {

        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtrack(sum + i, list, i + 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> solution(int N) {

        result = new ArrayList<>();
        n = N;

        backtrack(0, new ArrayList<>(), 1);
        return result;
    }
}
