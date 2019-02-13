import java.util.Scanner;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data = data;
	}
}

public class RotateDoubly 
{
	private static Scanner ip = new Scanner(System.in);
	Node head;
	Node tail;
	
	public void createList(int data)
	{
		Node node = new Node(data);

		if( head == null )
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
		if(head == null){
			System.out.println("List is empty");
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
	
	public void RotateList()
	{
		Node ptr1 = head;
		Node ptr2 = tail;
		
		head = head.next;
		ptr1.prev = ptr2;
		ptr2.next = ptr1;
		ptr1.next.prev = null;
		ptr1.next = null;
		tail = ptr1;		
		
	}
	
	public static void main(String[] args) 
	{
		RotateDoubly obj = new RotateDoubly();
		
		System.out.println("Enter size and elements");
		int size = ip.nextInt();
		
		for(int i=0 ; i<size; i++)
		{
			int n = ip.nextInt();
			obj.createList(n);
		}
		
		System.out.println("Link list is :");
		obj.display();
		
		
		System.out.println("Enter value to rotate");
		int val = ip.nextInt();
		
		for(int i=0 ; i<val ; i++)
			obj.RotateList();
		System.out.println("Link list after rotation");
		obj.display();
			
		ip.close();
	}
}
