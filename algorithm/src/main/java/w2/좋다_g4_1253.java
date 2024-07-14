package w2;

import java.io.*;
import java.util.*;

public class 좋다_g4_1253 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int count = 0;

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이 --------------------------------------
        // -1 0 1 2 -2
        Arrays.sort(arr);

        // -2 -1 0 1 2
        for (int i = 0; i < arr.length; i++) {

            int left = 0;
            int right = arr.length - 1;

            while(left < right){

                if(arr[left] + arr[right] == arr[i]){

                    // 자기 자신은 포함하지 않기 위해 아래 로직이 필요
                    if(i == right){
                        right--;
                    } else if(i == left){
                        left++;
                    } else{
                        count++;
                        break;
                    }

                } else if(arr[left] + arr[right] > arr[i]){
                    right--;
                } else{
                    left++;
                }
            }

        }

        System.out.println(count);
    }
}

/**
 * 틀렸던 코드 ----------------- => 음수 케이스를 고려 못함
 * 처음에는 arr sort 후 자기 자신보다 큰 수는 백날 더해도 다른 수가 나온다고 착각.
 * ex) 1 2 3 4 5 => 4가 나와야 한다면 4보다 큰 수는 5가 절대 포함 안된다고 생각.
 * 그래서 right 오른쪽 포인터는 i인 자기자신보다 작아야 한다고 로직을 구성했었음.
 */
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        int count = 0;
//
//        // 초기화
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // 풀이 --------------------------------------
//        Arrays.sort(arr);
//
//        for(int i = 0; i < arr.length; i++){
//
//            int left = 0;
//            int right = i - 1;
//
//            while (left < right){
//
//                if(arr[left] + arr[right] == arr[i]){
//                    count++;
//                    break;
//                } else if(arr[left] + arr[right] > arr[i]){
//                    right--;
//                } else{
//                    left++;
//                }
//            }
//        }
//
//        System.out.println(count);
//    }
//}
