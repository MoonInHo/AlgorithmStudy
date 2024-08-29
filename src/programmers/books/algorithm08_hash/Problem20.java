package programmers.books.algorithm08_hash;

import java.util.HashMap;
import java.util.Scanner;

public class Problem20 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wantSize = scanner.nextInt();

        scanner.nextLine();

        String[] want = new String[wantSize];
        for (int i = 0; i < wantSize; i++) {
            want[i] = scanner.nextLine();
        }

        int[] number = new int[wantSize];
        for (int i = 0; i < wantSize; i++) {
            number[i] = scanner.nextInt();
        }

        int discountSize = scanner.nextInt();
        String[] discount = new String[discountSize];

        scanner.nextLine();

        for (int i = 0; i < discountSize; i++) {
            discount[i] = scanner.nextLine();
        }

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {

        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {

            HashMap<String, Integer> discount10d = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }
            if (discount10d.equals(wantMap)) {
                answer++;
            }
        }
        return answer;
    }
}
