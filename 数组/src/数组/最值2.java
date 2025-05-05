package 数组;

import java.util.Scanner;
public class 最值2 {

	public static void main(String[] args) {
		 System.out.println("请输入10个数：");
	        Scanner in = new Scanner(System.in);
	        int[] b=new int[10];
	        for(int i=0;i<b.length;i++){
	        b[i]=in.nextInt();
	        }
	        int max=b[0];
            int min=b[0];
            int sum=0;
   		 //求數組最大值
   		 for(int i=0; i<b.length;i++){
   			 if(b[i]>max) max=b[i];
   		 }
   		 System.out.println("\n该输入产生的数组最大值是："+max);
   		 //求數組最小值
   		 for(int j = 0; j<b.length;j++){
   			 if(b[j]<min)min=b[j];
   		 }
   		 System.out.println("该输入产生的数组最小值是："+min);
   		//求數組的平均值
   		       for(int k = 0; k<b.length; k++){
   		   sum+=b[k];
   		       }
   		       int avg=sum/b.length;
   		       System.out.println("该输入产生的数组的平均值是："+avg);
   		//求和
   		       for(int l = 0; l < b.length; l ++){

   		    	   sum += b[l];
   		    	   }
   		    	   System.out.println("该输入产生的数组和是："+sum);
   		 
    }  
	
}
