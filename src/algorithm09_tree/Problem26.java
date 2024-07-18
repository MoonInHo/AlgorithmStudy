package algorithm09_tree;

import java.util.Scanner;

public class Problem26 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(solution(n, a, b));
    }

    public static int solution(int n, int a, int b) {

        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}
