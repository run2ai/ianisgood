package com.cosign.apple.inapp.presentation.controller.migration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA_비밀번호_s2_12891 {

    static int[] nowPwd;
    static int[] checkPwd;
    static int okCount;

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); // 전체 길이
        int p = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        String str = br.readLine(); // 비밀번호 문자열
        char[] pwd = str.toCharArray(); // 비밀번호 문자 배열

        nowPwd = new int[4]; // 현재 ACGT 비밀번호 갯수 ex) 0 0 0 0
        checkPwd = new int[4]; // 검증할 비밀번호 갯수 ex) 1 0 0 1
        okCount = 0; // 비밀번호 숫자가 하나 이상 맞을 경우 ++해준다.
        int result = 0; // 정답

        st = new StringTokenizer(br.readLine());

        // 검증할 비밀번호 갯수 초기화
        for(int i = 0; i < 4; i++){
            checkPwd[i] = Integer.parseInt(st.nextToken());
            if(checkPwd[i] == 0){
                okCount++; // 0은 이미 조건에 맞기 때문에 넣음.
            }
        }

        // 풀이 ----------------------------------------------------------------------------

        // 첫번째 초기화 - 한글자씩 확인
        for(int i = 0; i < p; i++){
            addNum(pwd[i]);
        }

        if(okCount == 4){
            result++;
        }

        // 슬라이딩 윈도우
        for(int right = p; right < s; right++){
            int left = right - p;
            addNum(pwd[right]);
            removeNum(pwd[left]);

            if(okCount == 4){
                result++;
            }
        }

        System.out.println(result);
    }

    private static void addNum(char pwd) {

        if(pwd == 'A'){
            nowPwd[0]++;
            if(nowPwd[0] == checkPwd[0]){
                okCount++;
            }
        }

        if(pwd == 'C'){
            nowPwd[1]++;
            if(nowPwd[1] == checkPwd[1]){
                okCount++;
            }
        }

        if(pwd == 'G'){
            nowPwd[2]++;
            if(nowPwd[2] == checkPwd[2]){
                okCount++;
            }
        }

        if(pwd == 'T'){
            nowPwd[3]++;
            if(nowPwd[3] == checkPwd[3]){
                okCount++;
            }
        }
    }

    private static void removeNum(char pwd) {

        if(pwd == 'A'){
            if(nowPwd[0] == checkPwd[0]){
                okCount--;
            }
            nowPwd[0]--;
        }

        if(pwd == 'C'){
            if(nowPwd[1] == checkPwd[1]){
                okCount--;
            }
            nowPwd[1]--;
        }

        if(pwd == 'G'){
            if(nowPwd[2] == checkPwd[2]){
                okCount--;
            }
            nowPwd[2]--;
        }

        if(pwd == 'T'){
            if(nowPwd[3] == checkPwd[3]){
                okCount--;
            }
            nowPwd[3]--;
        }
    }
}

