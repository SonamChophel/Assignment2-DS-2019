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

public class MergeList 
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
	
	public void mergeLists(MergeList obj1 , MergeList obj2 , MergeList obj3)
	{
		Node p1 = obj1.head;
		Node p2 = obj2.head;
		
		while( p1 != null && p2 != null )
		{
			if( p1.data > p2.data )
			{
				obj3.insertNode(p2.data);
				p2 = p2.next;
			}
			else if( p1.data < p2.data )
			{
				obj3.insertNode(p1.data);
				p1 = p1.next;
			}
			else
			{
				obj3.insertNode(p1.data);
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		
		while( p1 != null )
		{
			obj3.insertNode(p1.data);
			p1 = p1.next;
		}
		
		while( p2 != null )
		{
			obj3.insertNode(p2.data);
			p2 = p2.next;
		}		
	}
	public static void main(String[] args) 
	{
		MergeList obj1 = new MergeList();
		MergeList obj2 = new MergeList();
		MergeList obj3 = new MergeList();
		
		System.out.println("Enter size and elements for first list");
		int size1 = ip.nextInt();
		
		for(int i=0 ; i<size1 ; i++ )
		{
			int n1 = ip.nextInt();
			obj1.insertNode(n1);
		}
		
		System.out.println("Enter size and elements for second list");
		int size2 = ip.nextInt();
		
		for(int i=0 ; i<size2 ; i++ )
		{
			int n2 = ip.nextInt();
			obj2.insertNode(n2);
		}
		
		System.out.println("Elements of first list are :");
		obj1.display();
		
		System.out.println("Elements of second list are :");
		obj2.display();
		
		obj3.mergeLists(obj1,obj2,obj3);
		System.out.println("List after it is merged :");
		obj3.display();
		
		ip.close();	
	}
}
