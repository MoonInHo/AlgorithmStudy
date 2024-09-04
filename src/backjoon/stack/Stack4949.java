package backjoon.stack;

import java.io.*;
import java.util.ArrayDeque;

public class Stack4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (true) {

            String str = br.readLine();

            if (str.equals(".")) break;

            String[] strs = str.split("");

            for(String s : strs){
                switch (s) {
                    case ("("):
                    case ("["):
                        stack.push(s);
                        break;
                    case (")"):
                        if(!stack.isEmpty() && stack.peek().equals("(")) stack.pop();
                        else stack.push(")");
                        break;
                    case ("]"):
                        if(!stack.isEmpty() && stack.peek().equals("[")) stack.pop();
                        else stack.push("]");
                        break;
                }
            }
            if (stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");

            stack.clear();
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
