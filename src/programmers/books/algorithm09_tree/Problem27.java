package programmers.books.algorithm09_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem27 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int enrollAndReferralSize = scanner.nextInt();
        int sellerAndAmountSize = scanner.nextInt();

        String[] enroll = new String[enrollAndReferralSize];
        String[] referral = new String[enrollAndReferralSize];
        String[] seller = new String[sellerAndAmountSize];
        int[] amount = new int[sellerAndAmountSize];

        scanner.nextLine();

        for (int i = 0; i < enrollAndReferralSize; i++) {
            enroll[i] = scanner.nextLine();
        }
        for (int i = 0; i < enrollAndReferralSize; i++) {
            referral[i] = scanner.nextLine();
        }
        for (int i = 0; i < sellerAndAmountSize; i++) {
            seller[i] = scanner.nextLine();
        }
        for (int i = 0; i < sellerAndAmountSize; i++) {
            amount[i] = scanner.nextInt();
        }

        int[] result = solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> total = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {

            String curName = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !curName.equals("-")) {
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
                curName = parent.get(curName);
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}
