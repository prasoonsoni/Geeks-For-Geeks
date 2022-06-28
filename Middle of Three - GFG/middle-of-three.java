// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int A=Integer.parseInt(S[0]);
            int B=Integer.parseInt(S[1]);
            int C=Integer.parseInt(S[2]);
            Solution ob = new Solution();
            System.out.println(ob.middle(A,B,C));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int middle(int A, int B, int C){
        if((A>B && B>C) || C>B && B>A){
            return B;
        } else if((B>A && A>C) || (C>A && A>B)){
            return A;
        } else {
            return C;
        }
    }
}