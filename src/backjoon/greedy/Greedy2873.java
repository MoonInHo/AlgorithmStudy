package backjoon.greedy;

import java.util.Scanner;

public class Greedy2873 {

    public static void main(String[] args) { // TODO 다시 풀기

        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();

        int[][] arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        char[] resultArr = new char[(R * C) - 1];

        if (R % 2 == 0 && C % 2 == 0) {
            // R, C 모두 짝수일 경우
        } else if (R == 2) {
            // row 가 두개
        } else if (C == 2) {
            // column 이 두개
        } else if (R % 2 == 1) { // row 가 홀수, column 이 3 이상
            findOptimalPathForOddRows(C, resultArr);
        } else { // column 이 홀수, row 가 3 이상
            findOptimalPathForOddColumns(R, resultArr);
        }

        String result = new String(resultArr);
        System.out.println(result);

        // 행 or 열이 홀수일 경우 전체 방문 가능
        // 행 or 열이 짝수일 경우 한칸 빼고 방문 가능 (도착지의 왼쪽 혹은 위쪽 둘 중 하나)

        // 1 2 3 4 5
        // 1 2 3 4 5
        // 4 3 2 1 5
        // 4 3 2 1 5

        // C % 2 == 1 일 경우 D을 R-1번, R를 1번, U을 R-1번, R를 1번.. C-1 까지 반복

        // 1 2 3 4
        // 2 3 4 5
        // 3 4 5 1
        // 4 5 1 2
        // 5 1 2 3

        // R % 2 == 1 일 경우 R을 C-1번, D를 1번, L를 C-1번, D를 1번.. R-1 까지 반복

        // 1 2 3 4
        // 5 4 3 1
        // 1 2 3 4
        // 5 4 3 2

        // R, C 둘 다 짝수일 경우
        // 마지막 값 위치의 R-1, C-1 의 값중 큰 값을 확인

        // 윗 값이 더 클 경우
        // D을 R-1번, R을 1번, U을 R-1번, R을 1번.. C-3 까지 반복 후 R을 1번, D을 1번, L을 1번, D을 1번.. 최종 장소에 도착하면 종료

        // 왼쪽 값이 더 클 경우
        // R을 C-1번, D를 1번, L를 C-1번, D를 1번.. R-3 까지 반복 후 D을 1번, R을 1번, U을 1번, R을 1번.. 최종 장소에 도착하면 종료

        // R 행 C 열
        // int[R][C] 배열 각각의 칸에 기쁨 수치가 주어짐
        // 맨 왼쪽 위에서 시작, 맨 오른쪽 아래서 종료
        // 현재 위치에서 위, 아래, 오른쪽, 왼쪽 인접한 위치로 이동 가능
        // 각 칸은 한번씩만 방문 가능 -> 모든 칸을 방문 하지 않아도
    }

    private static void findOptimalPathForOddRows(int C, char[] resultArr) {

        int row = 1;

        for (int i = 1; i <= resultArr.length; i++) {
            if (i % C == 0) {
                resultArr[i - 1] = 'D';
                row++;
            } else if (row % 2 == 1) {
                resultArr[i - 1] = 'R';
            } else {
                resultArr[i - 1] = 'L';
            }
        }
    }

    private static void findOptimalPathForOddColumns(int R, char[] resultArr) {

        int column = 1;

        for (int i = 1; i <= resultArr.length; i++) {
            if (i % R == 0) {
                resultArr[i - 1] = 'R';
                column++;
            } else if (column % 2 == 1) {
                resultArr[i - 1] = 'D';
            } else {
                resultArr[i - 1] = 'U';
            }
        }
    }
}
