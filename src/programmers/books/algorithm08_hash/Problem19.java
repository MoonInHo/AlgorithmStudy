package programmers.books.algorithm08_hash;

import java.util.HashMap;
import java.util.Scanner;

public class Problem19 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int participantSize = scanner.nextInt();
        int completionSize = scanner.nextInt();

        String[] participant = new String[participantSize];
        String[] completion = new String[completionSize];

        scanner.nextLine();

        for (int i = 0; i < participantSize; i++) {
            participant[i] = scanner.nextLine();
        }
        for (int i = 0; i < completionSize; i++) {
            completion[i] = scanner.nextLine();
        }

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String string : completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        for (String string : participant) {
            if (hashMap.getOrDefault(string, 0) == 0) {
                return string;
            }
            hashMap.put(string, hashMap.get(string) - 1);
        }
        return null;
    }
}
