package algorithm05_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem04 {

    /**\
     * @문제4
     * 수포자의 문제 찍기
     * - 1번 수포자가 찍는 방식 -> 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 ...
     * - 2번 수포자가 찍는 방식 -> 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5 ...
     * - 3번 수포자가 찍는 방식 -> 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 ...
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 저장된 배열 answers가 주어졌을 때
     * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 반환하도록 solution() 함수 작성
     * @제약조건
     * 1. 시험은 최대 10,000 문제로 구성
     * 2. 문제의 정답은 1, 2, 3, 4, 5 중 하나
     * 3. 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int problemLength = scanner.nextInt();
        if (problemLength > 10000) {
            return;
        }

        int[] answers = new int[problemLength];

        for (int i = 0; i < problemLength; i++) {

            int answerNumber = scanner.nextInt();
            if (answerNumber <= 0 || answerNumber > 5) {
                return;
            }
            answers[i] = answerNumber;
        }
        int[] solution = solution(answers);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] answers) {

        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
