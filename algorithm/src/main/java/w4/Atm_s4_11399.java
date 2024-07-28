package w4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Atm_s4_11399 {


    /**
     *  N(1 ≤ N ≤ 1,000), (1 ≤ Pi ≤ 1,000)
     *  이중 for문 가능
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        // 풀이 1-----------------------------------------------------------------------

//        int result = 0;
//
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j <= i; j++){
//                result += arr[j];
//            }
//        }
//        System.out.println(result);

        // 풀이 2-----------------------------------------------------------------------

        /**
         * (temp)(0)+1=1(result)+
         * (temp)(1)+2=3(result)+
         * (temp)(1+2)+3=6(result)+
         * (temp)(1+2+3)+3=9(result)+
         * (temp)(1+2+3+3)+4=13(result)+
         */
        int temp = 0;
        int result = 0;

        for(int i = 0; i < arr.length; i++){
            temp += arr[i];
            result += temp;
        }

        System.out.println(result);
    }
}