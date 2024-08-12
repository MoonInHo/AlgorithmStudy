package algorithm14_simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Problem63 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int toppingLength = scanner.nextInt();
        int[] topping = new int[toppingLength];

        for (int i = 0; i < toppingLength; i++) {
            topping[i] = scanner.nextInt();
        }
        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {

        int answer = 0;

        HashMap<Integer, Integer> toppingMap = new HashMap<>();
        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) + 1);
        }

        HashSet<Integer> toppingSet = new HashSet<>();

        for (int t : topping) {

            toppingSet.add(t);
            toppingMap.put(t, toppingMap.get(t) - 1);

            if (toppingMap.get(t) == 0) {
                toppingMap.remove(t);
            }

            if (toppingSet.size() == toppingMap.size()) {
                answer++;
            }
        }
        return answer;
    }
}
