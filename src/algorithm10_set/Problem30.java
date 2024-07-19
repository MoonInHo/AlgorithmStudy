package algorithm10_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem30 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int[][] operations = new int[k][3];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                operations[i][j] = scanner.nextInt();
            }
        }
        Boolean[] result = solution(k, operations);
        System.out.println(Arrays.toString(result));
    }

    private static int[] parent;

    public static Boolean[] solution(int k, int[][] operations) {

        parent = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operations) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }
        return answer.toArray(new Boolean[0]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
}
