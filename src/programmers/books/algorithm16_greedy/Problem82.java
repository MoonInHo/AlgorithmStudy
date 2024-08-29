package programmers.books.algorithm16_greedy;

import java.util.Scanner;

public class Problem82 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int stationsLength = scanner.nextInt();
        int[] stations = new int[stationsLength];

        for (int i = 0; i < stationsLength; i++) {
            stations[i] = scanner.nextInt();
        }

        int w = scanner.nextInt();

        System.out.println(solution(n, stations, w));
    }

    public static int solution(int n, int[] stations, int w) {

        int answer = 0;
        int location = 1;
        int idx = 0;

        while (location <= n) {
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            } else {
                location += 2 * w + 1;
                answer++;
            }
        }
        return answer;
    }
}
