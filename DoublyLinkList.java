import java.util.Scanner;

class Node6
{
	int data;
	Node6 next;
	Node6 prev;
	Node6(int data)
	{
		this.data = data;
	}
}

public class DoublyLinkList 
{
	private static Scanner ip = new Scanner(System.in);
	Node6 head;
	Node6 tail;
	static int count;
	
	public void createList(int data)
	{
		Node6 node = new Node6(data);

		if( head == null )
		{
			head = node;
			tail = node;
			count++;
		}
		else
		{
			tail.next = node;
			node.prev = tail;
			tail = node;
			count++;
		}
	}
	
	public void display()
	{
		if(head == null){
			System.out.println("List is empty");
		}
		else
		{
			Node6 ptr = head;
			while( ptr != null )
			{
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
			System.out.println();
		}
	}
	
	public void insertAt(int pos , int val)
	{
		Node6 temp = new Node6(val);
		if(pos > count+1 || pos <= 0)
		{
			System.out.println("Invalid Position");
		}
		else if(head == null || pos == 1)
		{
			temp.next = head;
			head.prev = temp;
			head = temp;
			count++;
		}
		else
		{
			int i=1;
			int p = pos-1;
			Node6 ptr = head;
			while(  i < p )
			{
				ptr = ptr.next;
				i++;
			}
			if(pos <= count)
			{
				temp.next = ptr.next;
				ptr.next.prev = temp;
				ptr.next = temp;
				temp.prev = ptr;
			}
			else
			{
				ptr.next = temp;
				temp.prev = ptr;
			}
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
				head.prev = null;
			}
			else
			{
				int i=1;
				Node6 ptr = head;
				while( i < pos )
				{
					ptr = ptr.next;
					i++;
				}
				if(pos < count)
				{
					ptr.prev.next = ptr.next;
					ptr.next.prev = ptr.prev;
				}
				else
				{
					ptr.prev.next = null;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		DoublyLinkList obj = new DoublyLinkList();
		
		System.out.println("Enter size and elements");
		int size = ip.nextInt();
		
		for(int i=0 ; i<size; i++)
		{
			int n = ip.nextInt();
			obj.createList(n);
		}
		
		System.out.println("Link list is :");
		obj.display();
		
		
		System.out.println("Enter position and value to insert");
		int pos = ip.nextInt();
		int val = ip.nextInt();
		
		obj.insertAt(pos,val);
		System.out.println("Link list after insertion");
		obj.display();
		
		System.out.println("Enter position to delete");
		int p = ip.nextInt();
		
		obj.deleteAt(p);
		System.out.println("Link list after deletion");
		obj.display();
		
		ip.close();
	}
}
