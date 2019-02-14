import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class CloneDoubly
{
	private static Scanner ip = new Scanner(System.in);
	
	Node head;
	Node tail;
	
	public void insertNode(int data)
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
		if( head == null )
		{
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
	
	public void cloneList(CloneDoubly o1 , CloneDoubly o2 )
	{
		if( o1.head == null )
		{
			System.out.println("List 1 is empty");
			return;
		}
		Node ptr = o1.head;
		while( ptr != null )
		{
			o2.insertNode(ptr.data);
			ptr = ptr.next;
		}
	}
	
	public static void main(String[] args)
	{
		CloneDoubly o1 = new CloneDoubly();
		CloneDoubly o2 = new CloneDoubly();
		
		System.out.println("Enter size :");
		int size = ip.nextInt();
		
		System.out.println("Enter elements");
		for( int i=0 ; i<size ; i++ )
		{
			int n = ip.nextInt();
			o1.insertNode(n);
		}
		
		System.out.println("Elements in list are :");
		o1.display();
		
		o2.cloneList(o1,o2);
		System.out.println("List after clone is done :");
		o2.display();
		
		ip.close();
	}
}