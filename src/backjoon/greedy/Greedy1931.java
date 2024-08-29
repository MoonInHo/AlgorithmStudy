package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetingTimes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetingTimes[i][0] = Integer.parseInt(st.nextToken());
            meetingTimes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetingTimes, (a1, a2) -> {
            if(a1[1]==a2[1]) return Integer.compare(a1[0], a2[0]);
            else return Integer.compare(a1[1], a2[1]);
        });

        int lastEndTime = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (lastEndTime <= meetingTimes[i][0]) {
                lastEndTime = meetingTimes[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}