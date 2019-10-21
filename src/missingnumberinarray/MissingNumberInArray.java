package missingnumberinarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MissingNumberInArray {
    private static final Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        //code
        int testCase = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int t = 1; t <= testCase; t++) {
            int arraySize = scan.nextInt();
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String arrayLine = scan.nextLine();
            int[] arr;
            if(arrayLine.contains(" ")){
                arr = Arrays.stream(arrayLine.split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }else{
                arr = new int[]{Integer.parseInt(arrayLine)};
            }

            int sum = 0;
            for(int i = 1; i <= arraySize; i++){
                sum += i;
            }

            int arraySum = 0;
            for(int i = 0; i < arraySize-1; i++){
                arraySum += arr[i];
            }
            System.out.println(sum-arraySum);
        }
        scan.close();
    }
}
