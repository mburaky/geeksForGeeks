package mergewithoutextraspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeWithoutExtraSpace {

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

            int size1=sizeArray[0];
            int size2=sizeArray[1];

            int n = size1 + size2;
            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i += 1) {

                    int temp = getTemp(arr1, arr2, size1, i);

                    int j;
                    for (j = i; j >= gap && getJMinusGap(arr1, arr2, size1, gap, j) > temp; j -= gap) {
                        if(j < size1){
                            arr1[j] = getJMinusGap(arr1, arr2, size1, gap, j);
                        }else{
                            arr2[j-size1] = getJMinusGap(arr1, arr2, size1, gap, j);
                        }

                    }
                    if(j < size1){
                        arr1[j] = temp;
                    }else{
                        arr2[j-size1] = temp;
                    }
                }
            }

            for(int a: arr1){
                System.out.print(a + " ");
            }
            for(int a: arr2){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static int getJMinusGap(int[] arr1, int[] arr2, int size1, int gap, int j) {
        int temp2;
        if((j - gap) < size1){
            temp2 = arr1[j - gap];
        }else{
            temp2 = arr2[j - gap-size1];
        }
        return temp2;
    }

    private static int getTemp(int[] arr1, int[] arr2, int size1, int i) {
        int temp;
        if (i < size1) {
            temp = arr1[i];
        } else {
            temp = arr2[i - size1];
        }
        return temp;
    }
}
