import java.util.Arrays;
import java.util.Scanner;
public class Quicksort 
{
	static int partition(int arr[],int left,int right)
	{
		int pivot = arr[right];
		int i=left-1;
		int j,temp;
	    for(j=left;j<right;j++)
	    {
	    	if(arr[j]<=pivot)
	    	{
	    		i++;
	    		temp=arr[j];
	    		arr[j]=arr[i];
	    		arr[i]=temp;
	    	}
	    }
	    i++;
	    temp=arr[right];
	    arr[right]=arr[i];
	    arr[i]=temp;
	    return i;
	}
	static void quicksort(int arr[],int left,int right)
	{
		if(left<right)
		{
			int pivot=partition(arr,left,right);
			quicksort(arr,left,pivot-1);
			quicksort(arr,pivot+1,right);
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
		quicksort(arr,0,num-1);
		System.out.println("entered array after sorting :"+Arrays.toString(arr));
	}
}
