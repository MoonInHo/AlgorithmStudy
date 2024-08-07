package algorithm13_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Problem56 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {

        s = s.substring(0, s.length() - 2).replace("{", "");
        String[] arr = s.split("},");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String[] numbers = arr[i].split(",");
            for (String number : numbers) {
                if (!set.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }
        return answer;
    }
}
