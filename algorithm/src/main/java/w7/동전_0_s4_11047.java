package w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_0_s4_11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = arr.length-1; i >= 0; i--){
            if(k / arr[i] > 0){
                result += k / arr[i];
                k = k % arr[i];
            }

            if(k == 0){
                break;
            }
        }
        System.out.println(result);
    }
}
