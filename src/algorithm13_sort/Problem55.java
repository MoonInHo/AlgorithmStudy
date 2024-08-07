package algorithm13_sort;

import java.util.*;

public class Problem55 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbersLength = scanner.nextInt();
        int[] numbers = new int[numbersLength];

        for (int i = 0; i < numbersLength; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {

        ArrayList<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
