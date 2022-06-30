// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zero = null, zero_curr = zero;
        Node one = null, one_curr = one;
        Node two = null, two_curr = two;
        
        while(head != null){
            int data = head.data;
            if(data == 0){
                if(zero == null){
                    zero = new Node(data);
                    zero_curr = zero;
                } else {
                    zero_curr.next = new Node(data);
                    zero_curr = zero_curr.next;
                }
            } else if(data == 1){
                if(one == null){
                    one = new Node(data);
                    one_curr = one;
                } else {
                    one_curr.next = new Node(data);
                    one_curr = one_curr.next;
                }
            } else if(data == 2){
                if(two == null){
                    two = new Node(data);
                    two_curr = two;
                } else {
                    two_curr.next = new Node(data);
                    two_curr = two_curr.next;
                }
            }
            head = head.next;
        }
        if(zero != null && one != null && two != null){
            zero_curr.next = one;
            one_curr.next = two;
            return zero;
        } else if(zero != null && one != null){
            zero_curr.next = one;
            return zero;
        } else if(zero != null && two != null){
            zero_curr.next = two;
            return zero;
        } else if(one != null && two != null){
            one_curr.next = two;
            return one;
        } else if(zero != null){
            return one;
        } else if(one != null){
            return one;
        } else if(two != null){
            return two;
        }
        return null;
    }
}


