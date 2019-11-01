package reversewordsinagivenstring;

import java.util.Scanner;

public class ReverseWordsInAGivenString {

    private static final Scanner scan = new Scanner(System.in);

    public static void main (String[] args){
        //code
        int testCase = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int t=1; t<=testCase; t++){
            String[] arr = scan.nextLine().split("\\.");
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            // function
            String result = "";
            for(int i = arr.length-1; i>=0; i--){
                result = result + arr[i];
                if(i != 0){
                    result += ".";
                }
            }
            System.out.println(result);
        }
        scan.close();
    }
}
