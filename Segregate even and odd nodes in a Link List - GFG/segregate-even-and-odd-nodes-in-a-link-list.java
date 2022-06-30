// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} // } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        Node even = null, even_curr = even;
        Node odd = null, odd_curr = odd;
        Node curr = head;
        while(curr != null){
            Node temp = new Node(curr.data);
            if(curr.data%2==0){
                if(even == null){
                    even = temp;
                    even_curr = even;
                } else {
                    even_curr.next = temp;
                    even_curr = even_curr.next;
                }
            } else {
                if(odd == null){
                    odd = temp;
                    odd_curr = odd;
                } else {
                    odd_curr.next = temp;
                    odd_curr = odd_curr.next;
                }
            }
            curr = curr.next;
        }
        // Adding both lists
        if(even_curr!=null && odd_curr!=null){
            even_curr.next = odd;
            odd_curr.next = null;
            return even;
        } else if(even_curr!=null){
            return even;
        } else if(odd_curr!=null){
            return odd;
        }
        return null;
    }
}