package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K_번째_수_s5_11004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) -1;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // -----------------------------------
        quickSelection(arr,0,n-1,k);
        System.out.println(arr[k]);
    }

    private static void quickSelection(int[] arr, int left, int right,int k){
        if(left>= right){
            return;
        }

        int pivotIdx = partition(arr,left,right);
        quickSelection(arr,left,pivotIdx-1,k);
        quickSelection(arr,pivotIdx+1,right,k);
    }

    private static int partition(int[] arr, int left, int right){
        int mid = (left + right) / 2;
        swap(arr,mid,left);

        int pv = arr[left];
        int pi = left;

        while(left < right){
            // 뒤에서 부터 pv보다 작거나 같은 수의 위치를 찾는다.
            while(arr[right] > pv && left < right){
                right--;
            }

            while (arr[left] <= pv && left < right){
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,left,pi);
        return left; // pivot의 위치 인덱스
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



}
