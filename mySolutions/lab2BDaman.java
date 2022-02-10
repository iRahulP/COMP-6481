
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lab2BDaman {

	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);		 
		int num=sc.nextInt();
		int arr[]=new int[num];;
		sc.nextLine();
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		
		
		for(int i=0;i<num;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			map.put(start, end);
			arr[i]=end-start;
		}
		
		
		
		int gamesize=sc.nextInt();
		int inputs[]=new int[gamesize];
		for(int i =0;i<gamesize;i++)
		{
			inputs[i]=sc.nextInt();
			
		}
		int A=1;
		int B=1;
		for(int i =0;i<gamesize;i++)
		{
			if(A==100 || B==100)
			{
				break;
			}
            if(i%2==0)
			{	
            	A=A+inputs[i];
//            	System.out.println("val of A is "+A);
				if(map.containsKey(A))
				{   
//					System.out.print(map.get(A)+ "  ");
					A=map.get(A);
					while(map.containsKey(A))
					{
						A=map.get(A);
					}
//					System.out.println("s or l");
				}
				
			}
            else {  
            	
            	B=B+inputs[i];
//            	System.out.println("val of B is "+B);
				if(map.containsKey(B))
				{
//					System.out.println(map.get(B));
//					A=map.get(A);
					B=map.get(B);
					while(map.containsKey(B))
					{
						B=map.get(B);
					}
					
//					System.out.println("s or l");
//					B=map.get(B);
				}
            }
			
		}
//		System.out.println();
		if(A>B)
		{
			System.out.println("A "+A);
		}
		if(B>A)
		{
			System.out.println("B "+B);
		}
//		System.out.println(A+"      "+B);
		
//		for(int i=0;i<num;i++) {
//			System.out.println(arr[i]);
//		}
//		for(int i =0;i<gamesize;i++)
//		{
//			
//			System.out.println(inputs[i]);
//			
//		}
		
		
		
		
		
		
//		for(int i=0;i<num;i++) {
////			System.out.println(num);
//			String arr1[]=sl[i].split(" ");
//			try {
//				int date=Integer.parseInt([0]);
//				int month=Integer.parseInt(strarr[1]);
//				int year=Integer.parseInt(strarr[2]);
//			}
//			
//		}
		

		sc.close();
		
		
	}
	
	
}