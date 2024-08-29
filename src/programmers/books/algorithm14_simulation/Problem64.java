package programmers.books.algorithm14_simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem64 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int red = scanner.nextInt();
        int white = scanner.nextInt();

        System.out.println(Arrays.toString(solution(red, white)));
    }

    public static int[] solution(int red, int white) {

        int totalSize = red + white;
        int sqrt = (int) Math.sqrt(totalSize);

        for (int vertical = 3; vertical <= sqrt; vertical++) {
            if (totalSize % vertical == 0) {
                int horizontal = totalSize / vertical;
                if (red == (horizontal + vertical - 2) * 2) {
                    return new int[]{horizontal, vertical};
                }
            }
        }
        return new int[]{};
    }
}
