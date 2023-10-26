package codingChallenge;
import java.util.*;

class Delete_Kth_Node
{
	Node head;	
	
	void addToTheLast(Node node)
	{
		if(head == null)
		head = node;
		else
		{
			Node temp = head;
			while(temp.next != null)
			temp = temp.next;
			
			temp.next = node;
		} }	
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			Delete_Kth_Node list = new Delete_Kth_Node();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				list.addToTheLast(new Node(a));
			}
			int K = sc.nextInt();					  
			//System.out.println(list.head.data+" "+ k);
			list.head = new Code().delete(list.head,K); 
			Node temp = list.head;
			while(temp!=null)
			{
				System.out.print(temp.data+ " ");
			    temp = temp.next;
			}
			System.out.println();
	}
}
 
class Code
{
    
    Node delete(Node head, int K)
    {
          //write your code here
		  if(K == 1 ){
			  head = null;
			  return head;
		  }
		  if (head == null || head.next == null){
			  return head;
		  }
		//    solving 
		int c = 1;
		Node temp = head;
		while(temp != null && temp.next != null){
			if(c == K - 1){
				Node nex = temp.next;
				temp.next = nex.next;
				nex = null;
				temp = temp.next;
				c= 1;
			} else {
				c++;
				temp = temp.next;
			}
		}
        return head;
    }
}
 
class Node
{
	Node next;
	int data;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}