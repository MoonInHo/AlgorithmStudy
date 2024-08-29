package programmers.books.algorithm06_stack;

import java.util.Scanner;
import java.util.Stack;

public class Problem13 {

    /**
     * @문제13 (권장 시간 60분 / 권장 시간 복잡도 O(N^2 + M))
     * N * N 의 크기를 가지는 인형 뽑기 게임이 있다. 인형의 모양은 제각각 이며
     * 크레인의 위치가 담긴 moves 를 입력받아 배열의 순서대로 위쪽 부터 인형을 뽑아 바구니에 담는다.
     * 바구니에 같은 인형이 연속적으로 담길 경우 연속된 두 인형이 사라진다고 할 때 바구니에 남는 인형의 총 갯수를 구하시오.
     * @제약조건
     * 1. board 는 2차원 배열, 크기는 5 * 5 이상 30 * 30 이하
     * 2. board 의 각 칸에는 0 이상 100 이하인 정수가 담겨 있음
     *  - 0은 빈칸
     *  - 1 ~ 100의 각 숫자는 각기 다른 모양의 인형을 의미하며 같은 숫자는 같은 모양의 인형을 의미
     * 3. moves 배열의 크기는 1 이상 1,000 이하
     * 4. moves 배열의 각 원소들으 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int boardSize = scanner.nextInt();
        int[][] board = new int[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int movesSize = scanner.nextInt();
        int[] moves = new int[movesSize];

        for (int i = 0; i < movesSize; i++) {
            moves[i] = scanner.nextInt();
        }

        int result = solution(board, moves);

        System.out.println(result);
    }

    public static int solution(int[][] board, int[] moves) {

        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        Stack<Integer> bucket = new Stack<>();

        int answer = 0;

        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move - 1].pop();
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }
        return answer;
    }
}
