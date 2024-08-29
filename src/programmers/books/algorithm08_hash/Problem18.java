package programmers.books.algorithm08_hash;

import java.util.HashSet;
import java.util.Scanner;

public class Problem18 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.println(solution(arr, target));
    }

    public static boolean solution(int[] arr, int target) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            if (hashSet.contains(target - i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }
}
