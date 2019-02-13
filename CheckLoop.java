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

public class CheckLoop 
{
	private static Scanner ip = new Scanner(System.in);

	Node head;
	
	public void createList(int data)
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
	public boolean checklooop()
	{
		if( head == null || head.next == null || head.next.next==null )
			return false;
		
		Node s = head , f = head.next;
		
		while( f.next != null && f.next.next != null && s != f )
		{
			s = s.next;
			f = f.next.next;
		}
		if( s == f)
			return true;
		else
			return false;
	}
	
	public void testloop()
	{
		Node ptr = head;
		while( ptr.next != null )
			ptr = ptr.next;
		
		ptr.next = head;
	}
	public static void main(String[] args) 
	{
		CheckLoop obj = new CheckLoop();
		
		System.out.println("Enter size and list elements");
		int size = ip.nextInt();
		
		for(int i=0 ; i<size ; i++ )
		{
			int n = ip.nextInt();
			obj.createList(n);
		}
		
		System.out.println("Elements in List");
		obj.display();
		
		obj.testloop();
		
		if( obj.checklooop())
			System.out.println("Loop Encountered");
		else
			System.out.println("Loop Not Encountered");
		ip.close();
	}

}
