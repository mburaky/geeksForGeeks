package numberofpairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfPairs {

    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(in.readLine());

        for (int t = 1; t <= testCase; t++) {
            int[] sizeArray = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] arr1 = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] arr2 = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int counter=0;
            for(int e1 : arr1){
                for(int e2: arr2){
                    double xy = Math.log(e2) / Math.log(e1);
                    double yx = Math.log(e1) / Math.log(e2);
                    System.out.println(xy + ": " + e1 + " " + e2);
                    System.out.println(yx + ": " + e2 + " " + e1);
                    System.out.println( xy > yx);
                    if(xy > yx){
                        counter++;
                    }
                }

            }
            System.out.println(counter);
        }
    }
}
