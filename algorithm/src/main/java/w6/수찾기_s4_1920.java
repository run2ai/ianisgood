package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_s4_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(st.nextToken());
            int result = binarySearch(x,arr);

            if(arr[result] == x){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }

    private static int binarySearch(int x, int[] arr) {

        int low = 0;
        int hi = arr.length-1;

        while(low < hi){

            int mid = (hi + low) / 2;

            if(x > arr[mid]){
                low = mid+1;
            } else{
                hi = mid;
            }
        }

        return low;

    }
}
