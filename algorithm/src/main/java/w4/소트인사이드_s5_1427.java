package w4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 소트인사이드_s5_1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        Integer[] arr = new Integer[n.length()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = n.charAt(i) - '0';
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
