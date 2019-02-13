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

public class SortDoublyList 
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
	
	public void sortList()
	{
		Node p1 = head;
		Node p2 = head;
		while(p1 != null ){
			p2 = p1.next;
			while( p2 != null )
			{
				if( p1.data >= p2.data )
				{
					int d = p1.data;
					p1.data = p2.data;
					p2.data = d;
				}
				p2 = p2.next;
			}
			p1 = p1.next;
		}
	}
	
	public static void main(String[] args) 
	{
		SortDoublyList o = new SortDoublyList();
		
		System.out.println("Enter size and elements");
		int s = ip.nextInt();
		
		for(int i=0 ; i<s ; i++ )
		{
			int n = ip.nextInt();
			o.insertNode(n);
		}
		
		System.out.println("List is :");
		o.display();
		
		o.sortList();
		System.out.println("List after sorting is :");
		o.display();
		ip.close();
	}
}
