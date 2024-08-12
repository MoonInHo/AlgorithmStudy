package algorithm14_simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem62 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {

        int countTransform = 0;
        int countZero = 0;

        while (!s.equals("1")) {

            countTransform++;

            int zero = s.replace("1", "").length();
            countZero += zero;

            s = Integer.toBinaryString(s.length() - zero);
        }
        return new int[]{countTransform, countZero};
    }
}
