package org.study.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 평균_b1_1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int subjects = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        double result = 0.0;
        double[] arr = new double[subjects];

        // 초기화
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            result += (arr[i] / arr[arr.length-1]) * 100;
        }

        System.out.println(result/subjects);
    }
}
