// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0;i<size;i++){
            if(count.containsKey(a[i])){
                count.put(a[i], count.get(a[i])+1);
            } else {
                count.put(a[i], 1);
            }
        }
        Set<Integer> keys = count.keySet();
        for(Integer i : keys){
            if(count.get(i) > size/2){
                return i;
            }
        }
        return -1;
    }
}