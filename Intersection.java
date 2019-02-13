import java.util.*;

class Node
{
	Node next;
	int data;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

public class Intersection 
{
	private static Scanner ip = new Scanner(System.in);
	
	Node head;
	public void insertNode(int data)
	{
		Node node = new Node(data);
		if( head == null )
		{
			head = node;
		}
		else
		{
			Node ptr = head;
			while( ptr.next != null )
				ptr = ptr.next;
			ptr.next = node;
		}
	}
	
	public void display()
	{
		if( head == null )
			System.out.println("List Is Empty");
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
	
	public void findIntersection(Intersection o1 , Intersection o2 , Intersection o3 )
	{
		Node p1 = o1.head;
		Node p2 = o2.head;
		
		while( p1.next != null && p2.next != null )
		{
			if( p1.data > p2.data )
			{
				p2 = p2.next;
			}
			else if( p1.data < p2.data )
			{
				p1 = p1.next;
			}
			else
			{
				o3.insertNode(p1.data);
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		
		while( p1 != null )
		{
			if( p2 != null )
			{
				if( p2.data == p1.data)
				{
					o3.insertNode(p1.data);
					p1 = p1.next;
				}
			}
			else
				p1 = p1.next;
		}
		
		while( p2 != null )
		{
			if( p1 != null )
			{
				if( p2.data == p1.data)
				{
					o3.insertNode(p2.data);
					p2 = p2.next;
				}
			}
			else
				p2 = p2.next;
		}
	}
	
	public static void main(String[] args) 
	{
		Intersection o1 = new Intersection();
		Intersection o2 = new Intersection();
		Intersection o3 = new Intersection();
		
		System.out.println("Enter size and elements for first list");
		int size1 = ip.nextInt();
		
		for(int i=0 ; i<size1 ; i++ )
		{
			int n1 = ip.nextInt();
			o1.insertNode(n1);
		}
		
		System.out.println("Enter size and elements for second list");
		int size2 = ip.nextInt();
		
		for(int i=0 ; i<size2 ; i++ )
		{
			int n2 = ip.nextInt();
			o2.insertNode(n2);
		}
		
		System.out.println("Elements of first list are :");
		o1.display();
		
		System.out.println("Elements of second list are :");
		o2.display();
		
		o3.findIntersection(o1,o2,o3);
		System.out.println("List after intersection :");
		o3.display();
		
		ip.close();	
	}
}
