import java.util.Scanner;
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}
}


public class SinglyLinkList 
{
	private static Scanner ip = new Scanner(System.in);
	static int count;
	Node head;
	
	public void createList(int data)
	{
		Node node = new Node(data);
		if( head == null )
		{
			head = node;
			count++;
		}
		else
		{
			Node ptr = head;
			while( ptr.next != null)
				ptr = ptr.next;
			ptr.next = node;
			count++;
		}
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("List is Empty");
		}
		else
		{
			Node ptr = head;
			while( ptr != null)
			{
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
			System.out.println();
		}
	}
	
	public void insertAt(int pos , int val)
	{
			Node temp = new Node(val);
			if(pos > count+1 || pos <= 0)
			{
				System.out.println("Invalid Position");
			}
			else if(head == null || pos == 1)
			{
				temp.next = head;
				head = temp;
				count++;
			}
			else
			{
				int i=1;
				int p = pos-1;
				Node ptr = head;
				while(  i < p )
				{
					ptr = ptr.next;
					i++;
				}
				temp.next = ptr.next;
				ptr.next = temp;
				count++;
			}
	}
	
	public void deleteAt(int pos)
	{
		if(head == null )
		{
			System.out.println("Empty List");
		}
		else
		{
			if(pos > count || pos <= 0)
	
			{
				System.out.println("Invalid Position");
			}
			else if(pos == 1)
			{
				head = head.next;
			}
			else
			{
				int p = pos - 1;
				int i=1;
				Node ptr = head;
				while( i < p )
				{
					ptr = ptr.next;
					i++;
				}
				ptr.next = ptr.next.next;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		SinglyLinkList obj = new SinglyLinkList();
		
		System.out.println("Enter size and list elements");
		int size = ip.nextInt();
		
		for(int i=0 ; i<size ; i++ )
		{
			int n = ip.nextInt();
			obj.createList(n);
		}
		
		System.out.println("Elements in List");
		obj.display();
		
		System.out.println("Enter position and value");
		int pos = ip.nextInt();
		int val = ip.nextInt();
		
		obj.insertAt(pos,val);
		System.out.println("Link list after insertion");
		obj.display();
		
		System.out.println("Enter position");
		int pos1 = ip.nextInt();
		
		obj.deleteAt(pos1);
		System.out.println("Link list after deletion");
		obj.display();
		ip.close();
	}

}
