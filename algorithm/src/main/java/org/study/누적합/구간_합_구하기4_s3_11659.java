package org.study.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기4_s3_11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        // 누적합 초기화
        arr[0] = 0;
        for(int i = 1; i <= n; i++){
           arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        // 풀이
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(arr[right]-arr[left-1]);
        }
    }
}
