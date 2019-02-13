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

public class CircularList 
{
	private static Scanner ip = new Scanner(System.in);
	
	Node head;
	Node tail;
	
	public void insertEnd(int data)
	{
		Node node = new Node(data);
		if( head == null )
		{
			node.next = node;
			node.prev = node;
			head = node;
			tail = node;
		}
		else
		{
			node.prev = tail;
			tail.next = node;
			node.next = head;
			head.prev = node;
			tail = node;
		}
	}
	
	public void traverse()
	{
		if( head == null )
		{
			System.out.println("List is Empty");
		}
		else
		{
			Node curr = head;
			
			while( curr.next != head )
			{
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			System.out.println(curr.data);
		}
	}
	
	public void printList(int val)
	{
		Node ptr = head;
		Node curr = null;
		while( ptr.next != head)
		{
			if( ptr.data == val)
			{
				curr = ptr;
				break;
			}
			ptr = ptr.next;
		}
		if( ptr.data == val)
		{
			curr = ptr;
		}
		while( curr.next != ptr )
		{
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	
	public static void main(String[] args) 
	{
		CircularList obj = new CircularList();
		
		System.out.println("Enter size and elements");
		int size = ip.nextInt();
		
		for(int i=0 ; i<size; i++ )
		{
			int n = ip.nextInt();
			obj.insertEnd(n);
		}
		
		System.out.println("List is :");
		obj.traverse();

		System.out.println("Enter data value");
		int val = ip.nextInt();
		
		System.out.println("List Printing from a specific data value :");
		obj.printList(val);	
		ip.close();
	}
}
