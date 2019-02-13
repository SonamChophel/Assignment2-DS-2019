import java.util.Scanner;

class Node
{
	Node next;
	Node prev;
	int data;
	
	Node(int data)
	{
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class DeleteAlternate 
{
	private static Scanner ip = new Scanner(System.in);
		
	Node head;
	Node tail;
	
	public void insertNode(int data)
	{
		Node node = new Node(data);
		if( tail == null )
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}
	
	
	public void display()
	{
		if( head ==  null )
		{
			System.out.println("List is Empty");
		}
		else
		{
			Node ptr = head;
			while( ptr != null )
			{
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
			System.out.println();
		}
	}
	
	public void deleteAlter()
	{
		if( head == null || head.next == null)
			return;
		Node ptr1 = head;
		Node ptr2 = ptr1.next;
		
		while( ptr1.next != null )
		{
			if(ptr2.next == null || ptr2 == null)
			{
				ptr1.next = null;
				break;
			}
			
			ptr1.next = ptr2.next;
			ptr2.next.prev = ptr1;
			ptr2.next = null;
			ptr1 = ptr1.next;
			ptr2 = ptr1.next;
		}
	}
	
	public static void main(String[] args)
	{
		DeleteAlternate  o = new DeleteAlternate();
		
		System.out.println("Enter size and elements");
		int s = ip.nextInt();
		
		for(int i=0 ; i<s ; i++ )
		{
			int n = ip.nextInt();
			o.insertNode(n);
		}
		
		System.out.println("List is :");
		o.display();
		
		o.deleteAlter();
		System.out.println("List after alteration is :");
		o.display();
	
		
		ip.close();
	}

}
