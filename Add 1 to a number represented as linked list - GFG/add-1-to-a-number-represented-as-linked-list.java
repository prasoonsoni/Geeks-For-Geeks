// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


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

class Solution
{
    public static Node addOne(Node head) 
    { 
       Node reversed = reverse(head);
       Node curr = reversed;
       curr.data = curr.data + 1;
       int carry = 0;
       if(curr.data==10){
           carry = 1;
           curr.data = 0;
       }
       curr = curr.next;
       while(curr != null){
           curr.data = curr.data + carry;
           if(curr.data==10){
               carry = 1;
               curr.data = 0;
           } else {
               carry = 0;
           }
           curr = curr.next;
       }
       if(carry==1){
           Node temp = reversed;
           while(temp.next != null){
               temp = temp.next;
           }
           temp.next = new Node(1);
       }
       
       return reverse(reversed);
    }
    
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
