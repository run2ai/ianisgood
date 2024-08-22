package w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_s1_1931 {

    /**
     * 종료 시간이 최대한 빠른걸 선택
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int count = 1;

        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 종료 시간 기준 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]){
                    return o1[0] - o2[1];
                }

                return o1[1] - o2[1];
            }
        });

        // ---------------------------------------------------------------------
        int start = arr[0][1];

        for(int i = 1; i < arr.length; i++){
            if(start <= arr[i][0]){
                start = arr[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}