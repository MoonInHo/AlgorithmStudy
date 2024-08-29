package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Greedy1439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();

        String[] arr = S.split("(?<=1)(?=0)|(?<=0)(?=1)");

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);

        for (String s : arr) {
            if (s.startsWith("0")) {
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
        }

        if (map.get(0) + map.get(1) == 1) {
            System.out.println(0);
        } else if (map.get(0) < map.get(1)) {
            System.out.println(map.get(0));
        } else {
            System.out.println(map.get(1));
        }
    }
}
