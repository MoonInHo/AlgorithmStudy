package backjoon.stack;

import java.io.*;
import java.util.ArrayDeque;

public class Stack10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (s.charAt(i - 1) == '(') result += stack.size();
                else result++;
            }
        }
        System.out.println(result);
        br.close();
    }
}
