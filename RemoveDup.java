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

public class RemoveDup 
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
			while( ptr.next != null)
				ptr = ptr.next;
			ptr.next = node;
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
	
	public void removeDupli()
	{
		Node ptr1 = head;
		Node ptr2 = head;
		Node preptr1 = null;
		Node preptr2 = null;
		
		while( ptr1 != null )
		{
			preptr2 = ptr1;
			ptr2 = ptr1.next;
			while( ptr2 != null)
			{
				if( ptr1.data == ptr2.data )
				{
					if( ptr2.next == null)
					{
						preptr2.next = null;
					}
					else
					{
						preptr2.next = ptr2.next;
					}
					ptr2 = preptr2; 
				}
				else
				{
					preptr2 = ptr2;
					ptr2 = ptr2.next;
				}
			}
			preptr1 = ptr1;
			ptr1 = ptr1.next;
		}
	}
	
	public static void main(String[] args) 
	{
		RemoveDup obj = new RemoveDup();
		
		System.out.println("Enter size and list elements");
		int size = ip.nextInt();
		
		for(int i=0 ; i<size ; i++ )
		{
			int n = ip.nextInt();
			obj.insertNode(n);
		}
		
		System.out.println("Elements in List");
		obj.display();
		
		obj.removeDupli();
		System.out.println("List After removal of duplicate numbers");
		obj.display();
		ip.close();
	}

}
