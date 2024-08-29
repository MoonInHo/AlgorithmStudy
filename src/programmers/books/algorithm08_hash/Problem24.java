package programmers.books.algorithm08_hash;

import java.util.*;

public class Problem24 {

    public static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ordersSize = scanner.nextInt();
        int courseSize = scanner.nextInt();

        scanner.nextLine();

        String[] orders = new String[ordersSize];
        int[] course = new int[courseSize];

        for (int i = 0; i < ordersSize; i++) {
            orders[i] = scanner.nextLine();
        }
        for (int i = 0; i < courseSize; i++) {
            course[i] = scanner.nextInt();
        }

        String[] result = solution(orders, course);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] orders, int[] course) {

        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o))
                    .ifPresent(cnt -> count.entrySet()
                            .stream()
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private static void combinations(int idx, char[] order, String result) {

        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());

            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }
}
