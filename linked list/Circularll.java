import java.util.*;
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}
public class Circularll
{
	Node head=null;
	Node tail=null;
	void insert(int data)
	{
		Node newnode = new Node(data);
		if(head==null)
		{
			head=newnode;
			tail=newnode;
			tail.next=head;
		}
		else
		{
			tail.next=newnode;
			newnode.next=head;
			tail=newnode;
		}
	}
	void display()
	{
		if(head==null)
		{
			System.out.println("linked list is empty:");
			return;
		}
		Node temp=head;
		do
		{
			System.out.print(temp.data+"  ->  ");
			temp=temp.next;
		}while(temp!=tail.next);
		System.out.print("head");
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Circularll list = new Circularll();
		System.out.println("enter the number of values to insert:");
		int num=sc.nextInt();
		int i;
		for(i=1;i<=num;i++)
		{
			System.out.println("enter the node  "+i);
			int data=sc.nextInt();
			list.insert(data);
		}
		System.out.println("linked list value:");
		list.display();
	}
}
