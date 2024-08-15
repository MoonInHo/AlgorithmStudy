package algorithm16_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem78 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int itemsLength = scanner.nextInt();
        int[][] items = new int[itemsLength][2];

        for (int i = 0; i < itemsLength; i++) {
            for (int j = 0; j < 2; j++) {
                items[i][j] = scanner.nextInt();
            }
        }

        int weight_limit = scanner.nextInt();

        System.out.println(solution(items, weight_limit));
    }

    private static class Item {

        int value, weight;
        double valuePerWeight;

        public Item(int value, int weight, double valuePerWeight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }
    }

    public static double solution(int[][] items, int weight_limit) {

        Item[] item = new Item[items.length];

        for (int i = 0; i < item.length; i++) {
            item[i] = new Item(items[i][1], items[i][0], (double) items[i][1] / items[i][0]);
        }

        Arrays.sort(item, (o1, o2) -> Double.compare(o2.valuePerWeight, o1.valuePerWeight));

        double totalValue = 0;
        int remainingWeight = weight_limit;

        for (Item i : item) {
            if (i.weight <= remainingWeight) {
                totalValue += i.value;
                remainingWeight -= i.weight;
            } else {
                double fraction = (double) remainingWeight / i.weight;
                totalValue += i.value * fraction;
                break;
            }
        }
        return totalValue;
    }
}
