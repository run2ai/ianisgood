package org.study.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의_합_b4_11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int result = 0;

        String[] arr = br.readLine().split("");

        for(int i = 0; i < count; i++){
            result += Integer.parseInt(arr[i]);
        }

        System.out.println(result);
    }
}
