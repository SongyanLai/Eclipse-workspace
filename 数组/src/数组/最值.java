package 数组;

import java.util.Scanner;
import java.util.Random;

public class 最值 {

	public static void main(String[] args) {
		
		//在主程序中定义两个长度为10的数组，通过键盘输入和随机数两种方式进行赋值，并分别求得两个数组中的最大元素、最小元素、平均值、和。
     int []number= new int[10];
     Random r = new Random();
     for (int ii = 0; ii <number.length; ii++) {
    	number[ii] = r.nextInt(10);
    	for(int l = 0; l<number.length; l++){
    		 System.out.print(number[l]+"\t");
    	}
             int max=number[0];
             int min=number[0];
             int sum=0;
    		 //求數組最大值
    		 for(int i=0; i<number.length;i++){
    			 if(number[i]>max) max=number[i];
    		 }
    		 System.out.println("\n该随机产生的数组最大值是："+max);
    		 //求數組最小值
    		 for(int j = 0; j<number.length;j++){
    			 if(number[j]<min)min=number[j];
    		 }
    		 System.out.println("该随机产生的数组最小值是："+min);
    		//求數組的平均值
    		       for(int k = 0; k<number.length; k++){
    		   sum+=number[k];
    		       }
    		       int avg=sum/number.length;
    		       System.out.println("该随机产生的数组的平均值是："+avg);
    		//求和
    		       for(int l = 0; l < number.length; l ++){

    		    	   sum += number[l];
    		    	   }
    		    	   System.out.println("该随机产生的数组和是："+sum);
    		 
     }
     
	

	}

         

     }

     
     

     
     
