package 数组;
import java.util.Scanner;
public class 最值3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double arr []= new double [10];
		for(int l = 0; l<arr.length; l++){
			 System.out.print(arr[l]+"\t");
			 }

	         double max=arr[0];
	         double min=arr[0];
	         int sum=0;
			 //求數組最大值
			 for(int i=0; i<arr.length;i++){
			 if(arr[i]>max) max=arr[i];
			 }
			 System.out.println("\n该随机产生的数组最大值是："+max);
			 //求數組最小值
			 for(int j = 0; j<arr.length;j++){
			 if(arr[j]<min)min=arr[j];
			 }
			 System.out.println("该随机产生的数组最小值是："+min);
			//求數組的平均值
			       for(int k = 0; k<arr.length; k++){
			   sum+=arr[k];
			       }
			       int avg=sum/arr.length;
			       System.out.println("该随机产生的数组的平均值是："+avg);
			//求和
			       for(int l = 0; l < arr.length; l ++){

			    	   sum += arr[l];
			    	   }
			    	   System.out.println("该随机产生的数组和是："+sum);
			 
		}
	
}

System.out.println("max="+max);
System.out.println("min="+min);
System.out.println("它们的和是"+d);
System.out.println("它们的平均数是"+(d/arr.length));
	}

	}
