package programmers.books.algorithm05_array;

import java.util.*;

public class Problem06 {

    /**\
     * @문제6
     * 전체 스테이지의 개수 N, 게임중인 사용자가 멈춰 있는 스테이지의 번호가 담긴 배열 stages 가 주어짐
     * 실패율이 높은 스테이지부터 내림차순으로 스테이지 번호가 담겨 있는 배열을 반환하도록 solution() 함수를 완성
     * 실패율 정의 : 스테이지에 도달했으나 아직 클리어 하지 못한 유저의 수 / 스테이지에 도달한 플레이어의 수
     * @제약조건
     * 1. 스테이지 개수 N은 1 이상 500 이하의 자연수
     * 2. stages 의 길이는 1 이상 200,000 이하
     * 3. stages 에는 1 이상 N+1 이하의 자연수가 존재
     *  a. 각 자연수는 사용자가 현재 도전 중인 스테이지 번호를 나타냄
     *  b. N+1 은 마지막 스테이지, 즉 N까지 클리어한 사용자를 나타냄
     * 4. 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지 오름차순
     * 5. 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 전체 스테이지의 개수
        if (n < 1 || n > 500) {
            return;
        }

        int stageLength = scanner.nextInt();
        int[] stages = new int[stageLength];

        for (int i = 0; i < stageLength; i++) {
            stages[i] = scanner.nextInt();
        }

        int[] result = solution(stages, n);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] stages, int n) {

        int[] challenger = new int[n + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= n; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        return fails.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
