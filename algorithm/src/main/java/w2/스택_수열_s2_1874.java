package w2;

import java.io.*;
import java.util.Stack;

public class 스택_수열_s2_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int[] arr = new int[n];
        int num = 1;
        boolean check = true;

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= num) {

                while (arr[i] >= num) {
                    stack.push(num);
                    result.append("+\n");
                    num++;
                }

                stack.pop();
                result.append("-\n");

            } else {
                int pop = stack.pop();

                if (pop > arr[i]) {
                    check = false;
                    break;
                } else {
                    result.append("-\n");
                }
            }
        }

        if (check) {
            bw.write(result.toString());
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
