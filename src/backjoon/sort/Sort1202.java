package backjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sort1202 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            jewelries[i] = new Jewelry(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });
        Arrays.sort(bags);

        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewelries[j].weight <= bags[i]) {
                pq.offer(jewelries[j++].price);
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        bw.write(sum + "");
        br.close();
        bw.close();
    }

    static class Jewelry {

        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
