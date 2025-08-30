import java.util.*;
class Implement
{
	int stack[];
	int top;
	int size;
	Implement(int size)
	{
		this.size=size;
		stack = new int[size];
		top=-1;
	}
	void push(int data)
	{
		if(top==size-1)
		{
			System.out.println("stack overflow");
			return;
		}
		else
		{
			stack[++top]=data;
			System.out.println("pushed value: "+data);
		}
	}
	void pop()
	{
		if(top==-1)
		{
			System.out.println("stack under flow");
			return;
		}
		else
		{
			System.out.println("popped value:"+stack[top--]);
		}
	}
	void peek()
	{
		if(top==-1)
		{
			System.out.println("stack under flow");
			return;
		}
		System.out.println("peek value :"+stack[top]);
	}
	void display()
	{
		int i,j=1;
		if(top==-1)
		{
			System.out.println("stack under flow");
			return;
		}
		for(i=0;i<top;i++)
		{
			System.out.println("value "+j+" : "+stack[i]);
			j++;
		}
	}
}
public class Stack
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size:");
		int size=sc.nextInt();
		Implement s = new Implement(size);
		int i,data;
		for(i=1;i<=size;i++)
		{
			System.out.println("enter the value "+i);
			data=sc.nextInt();
			s.push(data);
		}
	    System.out.println("stack elements :");
	    s.display();
	    s.pop();
	    System.out.println("stack elements after popping the element:");
	    s.display();
	    s.peek();
	}

}
