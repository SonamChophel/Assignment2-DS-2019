
import java.util.Scanner;

class Node4
{
	int data;
	Node4 next;
	Node4(int data)
	{
		this.data = data;
	}
}

public class CancelOutLinkList 
{
	private static Scanner ip = new Scanner(System.in);
	
	Node4 head;
	
	public void createList(int data)
	{
		Node4 node = new Node4(data);
		if( head == null )
		{
			head = node;
		}
		else
		{
			Node4 ptr = head;
			while( ptr.next != null)
				ptr = ptr.next;
			ptr.next = node;
		}
	}
	
	public void traverse()
	{
		Node4 ptr = head;
		if(head == null)
		{
			System.out.println("List is Empty");
		}
		else
		{
			while( ptr != null )
		
			{
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
			System.out.println();
		}
	}
	
	public void cancelElement()
	{
		Node4 ptr1 = head;
		Node4 ptr2 = head;
		Node4 preptr1 = null;
		Node4 preptr2 = null;
		int c = 0 ;
		
		while( ptr1 != null )
		{
			int flag = 0;
			preptr2 = ptr1;
			ptr2 = ptr1.next;
			while( ptr2 != null)
			{
				if( (ptr1.data + ptr2.data) == 0 )
				{
					flag = 1;
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
			
			if( flag == 1 )
			{
				if( c > 0 && ptr1 != head)
				{
					if( preptr1.next == null)
					{
						head = null;
					}
					else
					{
						preptr1.next = ptr1.next;
						ptr1 = preptr1;
					}
				}
				else
				{
					head = ptr1.next;
					ptr1 = head;
					preptr1 = ptr1;
				}
				
			}
			else
			{
				preptr1 = ptr1;
				ptr1 = ptr1.next;
			}
			c++;
		}
	}
	
	public static void main(String[] args) 
	{
		CancelOutLinkList o = new CancelOutLinkList();
		System.out.println("Enter size and elements in link list");
		int n = ip.nextInt();
		
		for(int i=0 ; i<n ; i++ )
		{
			int e = ip.nextInt();
			o.createList(e);
		}
		
		System.out.println("Link list is ");
		o.traverse();
		
		o.cancelElement();
		System.out.println("After elements are subtracted :");
		o.traverse();
		ip.close();
	}

}
