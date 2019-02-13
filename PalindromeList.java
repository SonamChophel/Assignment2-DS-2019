import java.util.Scanner;

class Node
{
	Node next;
	char data;
	
	Node(char data)
	{
		this.data = data;
	}
}

public class PalindromeList 
{
	private static Scanner ip = new Scanner(System.in);
	
	Node head;
	public void createList(char ch)
	{
		Node node = new Node(ch);
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
		{
			System.out.println("list is empty");
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
	
	public boolean checkPalindrome()
	{
		Node ptr = head;
		int len = 0;
		if( head == null || head.next == null )
			return true;
		while( ptr != null)
		{
			len++;
			ptr = ptr.next;
		}
		
		Node s = head;
		Node f = head;
		
		while( f != null && f.next != null )
		{
			s = s.next;
			f = f.next.next;
		}
		
		Node shead;
		if( len%2 == 0 )
		{
			shead = s;
		}
		else
		{
			shead = s.next;
			s.next = null;
		}
		
		Node nxt = null , prev = null , curr = shead;
		
		while( curr != null)
		{
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		shead = prev;
		
		Node ptr1 = head;
		while( shead != null )
		{
			if( shead.data != ptr1.data )
				return false;
			shead = shead.next;
			ptr1 = ptr1.next;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		PalindromeList o = new PalindromeList();
		
		System.out.println("Enter Character");
		String str = ip.nextLine();
		
		for(int i=0 ; i<str.length() ; i++ )
		{
			o.createList(str.charAt(i));
		}
		
		
		System.out.println("List is :");
		o.display();
		
		if( o.checkPalindrome())
			System.out.println("Linklist is palindrome");
		else
			System.out.println("LinkList is not palindrome");
		ip.close();
	}

}
