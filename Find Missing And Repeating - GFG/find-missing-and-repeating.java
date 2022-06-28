// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int [] result = new int[2];
        int [] count = new int[n];
        int uniqueSum = 0, sum=0;
        for(int i=0;i<n;i++){
            count[i] = 0;
        }
        for(int i=0;i<n;i++){
            count[arr[i]-1] += 1;
        }
        for(int i=0;i<n;i++){
            if(count[i] > 0){
                uniqueSum += i+1;
            }
            if(count[i]>1){
                result[0] = i+1;
            }
        }
        for(int i=1;i<=n;i++){
            sum += i;
        }
        
        result[1] = sum-uniqueSum;
        return result;
    }
}