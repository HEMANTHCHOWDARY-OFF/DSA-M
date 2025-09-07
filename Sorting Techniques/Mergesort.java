import java.util.*;
public class Mergesort 
{
	void merge(int arr[],int left,int mid,int right)
	{
		int i,j,k;
		int n1=mid-left+1;
		int n2=right-mid;
		int l[] = new int[n1];
		int r[] = new int[n2];
		for(i=0;i<n1;i++)
		{
			l[i]=arr[left+i];
		}
		for(i=0;i<n2;i++)
		{
			r[i]=arr[mid+1+i];
		}
		i=j=0;
		k=left;
		while(i<n1&&j<n2)
		{
			if(l[i]<=r[j])
			{
				arr[k]=l[i];
				i++;
			}
			else
			{
				arr[k]=r[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			arr[k]=l[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			arr[k]=r[j];
			j++;
			k++;
		}
	}
	void mergesort(int arr[],int left,int right)
	{
		int mid;
		if(left<right)
		{
			mid=(left+right)/2;
			mergesort(arr,left,mid);
			mergesort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("enter the number of elements to enter :");
		int num =sc.nextInt();
		int arr[] = new int[num];
		System.out.println("enter the values of an array:");
		int i;
		for(i=0;i<num;i++)
		{
			System.out.println("enter the value "+(i+1));
			arr[i]=sc.nextInt();
		}
		System.out.println("entered array before sorting :"+Arrays.toString(arr));
		Mergesort ms = new Mergesort();
		ms.mergesort(arr,0,num-1);
		System.out.println("entered array after sorting :"+Arrays.toString(arr));
	}
}
