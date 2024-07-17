package algorithm08_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int recordSize = scanner.nextInt();

        String[] record = new String[recordSize];

        scanner.nextLine();

        for (int i = 0; i < recordSize; i++) {
            record[i] = scanner.nextLine();
        }

        String[] result = solution(record);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] record) {

        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        HashMap<String, String> uid = new HashMap<>();

        for (String s : record) {
            String[] cmd = s.split(" ");
            if (cmd.length == 3) {
                uid.put(cmd[1], cmd[2]);
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] cmd = s.split(" ");
            if (msg.containsKey(cmd[0])) {
                answer.add(uid.get(cmd[1]) + msg.get(cmd[0]));
            }
        }

        return answer.toArray(new String[0]);
    }
}
