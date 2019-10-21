package subarraywwithgivensum;

import java.util.Arrays;
import java.util.Scanner;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        //code
        Scanner scan = new Scanner(System.in);
        int[] firstLineElements = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int testCaseNumber = firstLineElements != null
                && firstLineElements.length > 1 ? 1 : firstLineElements[0];

        if(testCaseNumber == 1){
            executeTestCase(scan, firstLineElements);
        }else {
            for(int i = 1; i <= testCaseNumber; i++){
                int[] secondLineElements = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                executeTestCase(scan, secondLineElements);
            }
        }
    }

    private static void executeTestCase(Scanner scan, int[] firstLineElements) {
        int sum = firstLineElements[1];
        int[] intArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean resultFound = false;
        outer:
        for (int j = 0; j < intArray.length; j++) {
            int tempSum = 0;
            int t = j;
            inner:
            while (t < intArray.length) {
                tempSum = tempSum + intArray[t];
                if (tempSum == sum) {
                    int result1 = j + 1;
                    int result2 = t + 1;
                    resultFound = true;
                    System.out.println("" + result1 + " " + result2);
                    break outer;
                } else if(tempSum > sum){
                    break inner;
                }
                t++;
            }
        }
        if(!resultFound){
            System.out.println("-1");
        }
    }
}
