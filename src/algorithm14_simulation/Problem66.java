package algorithm14_simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem66 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int keyinputSize = scanner.nextInt();
        String[] keyinput = new String[keyinputSize];
        int[] board = new int[2];

        scanner.nextLine();

        for (int i = 0; i < keyinputSize; i++) {
            keyinput[i] = scanner.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            board[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(solution(keyinput, board)));
    }

    private static int width, height;

    private static boolean isInBounds(int x, int y, int dx, int dy) {
        return Math.abs(x + dx) <= width && Math.abs(y + dy) <= height;
    }

    public static int[] solution(String[] keyinput, int[] board) {

        int x = 0, y = 0;

        HashMap<String, int[]> moves = new HashMap<>();
        moves.put("up", new int[]{0, 1});
        moves.put("down", new int[]{0, -1});
        moves.put("left", new int[]{-1, 0});
        moves.put("right", new int[]{1, 0});

        width = board[0] / 2;
        height = board[0] / 2;

        for (String key : keyinput) {

            int dx = moves.get(key)[0];
            int dy = moves.get(key)[1];

            if (isInBounds(x, y, dx, dy)) {
                x += dx;
                y += dy;
            }
        }
        return new int[]{x, y};
    }
}
