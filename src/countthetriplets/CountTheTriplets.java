package countthetriplets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountTheTriplets {

    private static final Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        //code
        int testCase = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 1; i <= testCase; i++) {
            int arraySize = scan.nextInt();
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arr);
            int max_value = arr[arraySize-1];

            HashSet<Integer> intSet = new HashSet<>();
            for(int m = 0; m < arraySize; m++){
                intSet.add(Integer.valueOf(arr[m]));
            }

            int counter = 0;
            for (int j = 0; j < arraySize; j++) {
                for (int t = j + 1; t < arraySize; t++) {
                    int sum = arr[j] + arr[t];
                    if (max_value < sum) {
                        break;
                    } else if (intSet.contains(sum)) {
                        counter++;
                    }
                }
            }
            System.out.println(counter > 0 ? counter : -1);
        }
        scan.close();
    }
}
