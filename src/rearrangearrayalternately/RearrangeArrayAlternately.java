package rearrangearrayalternately;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RearrangeArrayAlternately {

    public static void main (String[] args) throws IOException {
        //code
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(in.readLine());

        for(int t=1; t<=testCase; t++){
            int arraySize = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // function
            int[] result = new int[arraySize];
            int i = 0 ;
            int j = arraySize-1;
            int s = 0;

            boolean isEven = false;
            if(arraySize % 2 == 0){
                isEven = true;
            }

            while(s < result.length){
                if(isEven){
                    if(i >= j){
                        break;
                    }
                    result[s] = arr[j];
                    result[s+1] = arr[i];
                }
                else{
                    if(j == i){
                        result[s] = arr[i];
                        break;
                    }else{
                        result[s] = arr[j];
                        result[s+1] = arr[i];
                    }
                }
                i++;
                j--;
                s += 2;
            }

            for(int a: result){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
