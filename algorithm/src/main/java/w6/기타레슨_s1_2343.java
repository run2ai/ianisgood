package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨_s1_2343 {

    /**
     * i~j까지 모두 녹화, 순서 변경 x
     * 모든 기타 강의 동영상을 녹화
     * 블루레이의 크기를 최소 - M개의 블루레이는 모두 같은 크기
     * 1 2 3 4 5 6 7 8 9
     * 1개일 때 크기 45 - 최대
     * 9개일 때 크기 9 - 최소
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = Arrays.stream(arr).max().orElseThrow();
        int end = Arrays.stream(arr).sum();

        while(start <= end){

            int mid = (start + end) / 2;

            int temp = 0;
            int cnt = 0;

            for(int i = 0; i < arr.length; i++){

                // mid보다 더할 값이 크면 cnt++, 블루레이가 더 필요한 상황
                if(temp + arr[i] > mid){
                    temp = 0;
                    cnt++;
                }

                temp += arr[i];
            }

            // 마지막 값도 블루레이가 필요하기 때문에
            if(temp != 0) cnt++;

            if(cnt > m){
                start = mid + 1;
            } else{
                end = mid - 1;
            }

        }

        System.out.println(start);
    }
}
