package algorithm05_array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Problem07 {

    /**
     * @문제7
     * 게임 캐릭터를 4가지 방향으로 움직이려 합니다. 명령어는 다음과 같습니다.
     * - U : 위로 한 칸
     * - D : 아래쪽으로 한 칸
     * - R : 오른쪽으로 한 칸
     * - L : 왼쪽으로 한 칸
     * 캐릭터가 좌표 평면 (0, 0) 에서 시작하여 움직인다고 가정했을 때 캐릭터가 처음 걸어본 길의 거리를 구하시오.
     * @제약조건
     * 1. dirs 는 string 형으로 주어지며 'U', 'D', 'R', 'L' 이외의 문자는 주어지지 않음
     * 2. dirs 의 길이는 500 이하의 자연수
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String dirs = scanner.nextLine();

        int result = solution(dirs);

        System.out.println(result);
    }

    public static int solution(String dirs) {

        HashMap<Character, int[]> location = initLocation();

        int x = 5;
        int y = 5;

        HashSet<String> answer = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {

            int[] offset = location.get(dirs.charAt(i));

            int nx = x + offset[0];
            int ny = y + offset[1];

            if (!isValidMove(nx, ny)) {
                continue;
            }

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }

    private static HashMap<Character, int[]> initLocation() {

        HashMap<Character, int[]> location = new HashMap<>();

        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});

        return location;
    }

    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
}
