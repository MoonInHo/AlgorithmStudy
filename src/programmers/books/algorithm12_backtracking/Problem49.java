package programmers.books.algorithm12_backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Problem49 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int boardSize = scanner.nextInt();

        int[][] board = new int[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int[] aloc = new int[2];
        int[] bloc = new int[2];

        for (int i = 0; i < 2; i++) {
            aloc[i] = scanner.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            bloc[i] = scanner.nextInt();
        }
        System.out.println(solution(board, aloc, bloc));
    }

    private static class Result {

        boolean win;
        int step;

        public Result(boolean win, int step) {
            this.win = win;
            this.step = step;
        }
    }

    private static int ROW, COL;

    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {-1, 0, 1, 0};
    private static boolean[][] visited;
    private static int[][] Board;

    private static boolean isValidPos(int r, int c) {
        return 0 <= r && r < ROW && 0 <= c && c < COL;
    }

    private static Result recursive(int[] alpha, int[] beta, int step) {

        int[] now = step % 2 == 0 ? alpha : beta;
        boolean canMove = false;
        boolean isOpponentWinner = true;

        ArrayList<Integer> winSteps = new ArrayList<>();
        ArrayList<Integer> loseSteps = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            int nr = now[0] + DR[i];
            int nc = now[1] + DC[i];

            if (isValidPos(nr, nc) && !visited[nr][nc] && Board[nr][nc] == 1) {

                canMove = true;

                if (alpha[0] == beta[0] && alpha[1] == beta[1]) {
                    return new Result(true, step + 1);
                }

                visited[now[0]][now[1]] = true;

                Result result = step % 2 == 0
                        ? recursive(new int[]{nr, nc}, beta, step + 1)
                        : recursive(alpha, new int[]{nr, nc}, step + 1);

                visited[now[0]][now[1]] = false;

                isOpponentWinner &= result.win;

                if (result.win) {
                    winSteps.add(result.step);
                } else {
                    loseSteps.add(result.step);
                }
            }
        }

        if (!canMove) {
            return new Result(false, step);
        }
        if (isOpponentWinner) {
            return new Result(false, winSteps.stream().max(Comparator.comparingInt(o -> o)).get());
        }
        return new Result(true, loseSteps.stream().min(Comparator.comparingInt(o -> o)).get());
    }

    public static int solution(int[][] board, int[] aloc, int[] bloc) {

        Board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];

        return recursive(aloc, bloc, 0).step;
    }
}
