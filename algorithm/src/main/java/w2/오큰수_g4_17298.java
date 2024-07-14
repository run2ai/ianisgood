package w2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_g4_17298 {

    /**
     * 문제 이해
     * 4
     * 3 5 2 7
     * 3일 때 큰 수 {5,7} 왼쪽 5
     * 5일 때 큰수 {7} 7
     * 2일 때 큰 수 {7} 7
     * 7일 때 큰수 {} -1
     *
     * 1 <= N <= 1,000,000
     * 이중 배열 x, 시간 초과 - 1,000,000 * 1,000,000 => 1초 초과
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // ------------------------------------------


        // 3 5 2 7 - 원소
        // 인덱스 번호를 stack에 넣는다.
        for(int i = 0; i < arr.length; i++){


            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        // 위 결과
        // 5 7 7 7 - 배열의 원소 값
        // 3 - 스택의 남은 값

        while(!stack.isEmpty()) {

            int pop = stack.pop();
            arr[pop] = -1;
        }

        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i] + " ");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
