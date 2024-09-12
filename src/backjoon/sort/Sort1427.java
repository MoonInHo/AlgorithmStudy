package backjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Sort1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();

        Integer[] arr = N.chars().map(Character::getNumericValue).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());

        for (Integer integer : arr) {
            sb.append(integer);
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
