package algorithm14_simulation;

import java.util.Scanner;

public class Problem65 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        System.out.println(solution(N));
    }

    public static int solution(int N) {
        return Integer.toBinaryString(N).replace("0", "").length();
    }
}
