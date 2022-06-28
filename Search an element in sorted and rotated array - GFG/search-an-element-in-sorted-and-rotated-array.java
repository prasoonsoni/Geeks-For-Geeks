// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		array[i] = sc.nextInt();
        	}
        	int target = sc.nextInt();

            Solution ob = new Solution();
			System.out.println(ob.Search(array,target));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int Search(int arr[], int target)
	{
	    int start = 0;
	    int end = arr.length - 1;
	    while(start<=end){
	        int mid = (start + end)/2;
	        if(arr[mid] == target){
	            return mid;
	        }
	        if(arr[mid] >= arr[start]){
	            if(target>=arr[start] && target<arr[mid]){
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        } else {
	            if(target>=arr[mid] && target<arr[end]){
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	    }
	    return -1;
	}
} 

