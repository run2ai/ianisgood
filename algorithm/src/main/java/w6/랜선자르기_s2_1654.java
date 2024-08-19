package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기_s2_1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(arr);

        long high = Arrays.stream(arr).max().orElseThrow();
        long low = 1;

        while(low <= high){

            long mid = (high+low) / 2;
            long cnt = 0;

            for(int i = 0; i < arr.length; i++){
                cnt += (arr[i]) / mid;
            }

            if(cnt >= n){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}
