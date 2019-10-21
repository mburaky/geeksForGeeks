package kadanesalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KadanesAlgorithm {

    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(in.readLine());

        for(int i=1; i<=testCase; i++){
            int arraySize = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int maxSum = arr[0];
            int tempSum= arr[0];
            for(int t=1; t < arraySize; t++) {
                tempSum = Math.max(arr[t], arr[t] + tempSum);
                maxSum = Math.max(maxSum, tempSum);
            }
            System.out.println(maxSum);
        }
    }
}
