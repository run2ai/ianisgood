package w2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_s4_1940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int start = 0; // 시작
        int end = n-1; // 끝
        int result = 0; // 결과

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1 2 3 4 5 7
        Arrays.sort(arr);

        // 풀이
        while (start < end){

            if(arr[start] + arr[end] < m){
                start++;
            } else if(arr[start] + arr[end] > m){
                end--;
            } else if(arr[start] + arr[end] == m){
                result++;
                start++;
            }

        }
        System.out.println(result);
    }
}
