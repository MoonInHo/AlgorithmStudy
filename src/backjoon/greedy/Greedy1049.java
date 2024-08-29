package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy1049 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackagePrice = 1000;
        int minUnitPrice = 1000;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int packagePrice = Integer.parseInt(st.nextToken());
            int unitPrice = Integer.parseInt(st.nextToken());

            if (minPackagePrice > packagePrice) {
                minPackagePrice = packagePrice;
            }
            if (minUnitPrice > unitPrice) {
                minUnitPrice = unitPrice;
            }
        }

        int sum = 0;

        if (minPackagePrice > minUnitPrice * 6) {
            sum = minUnitPrice * N;
        } else if (minPackagePrice < minUnitPrice || minUnitPrice * (N % 6) > minPackagePrice) {
            sum = minPackagePrice * ((N + 5) / 6);
        } else {
            sum = (minUnitPrice * (N % 6)) + (minPackagePrice * (N / 6));
        }
        System.out.println(sum);
    }
}
