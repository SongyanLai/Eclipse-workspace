package ����;

import java.util.Scanner;
public class ��ֵ2 {

	public static void main(String[] args) {
		 System.out.println("������10������");
	        Scanner in = new Scanner(System.in);
	        int[] b=new int[10];
	        for(int i=0;i<b.length;i++){
	        b[i]=in.nextInt();
	        }
	        int max=b[0];
            int min=b[0];
            int sum=0;
   		 //�󔵽M���ֵ
   		 for(int i=0; i<b.length;i++){
   			 if(b[i]>max) max=b[i];
   		 }
   		 System.out.println("\n������������������ֵ�ǣ�"+max);
   		 //�󔵽M��Сֵ
   		 for(int j = 0; j<b.length;j++){
   			 if(b[j]<min)min=b[j];
   		 }
   		 System.out.println("�����������������Сֵ�ǣ�"+min);
   		//�󔵽M��ƽ��ֵ
   		       for(int k = 0; k<b.length; k++){
   		   sum+=b[k];
   		       }
   		       int avg=sum/b.length;
   		       System.out.println("����������������ƽ��ֵ�ǣ�"+avg);
   		//���
   		       for(int l = 0; l < b.length; l ++){

   		    	   sum += b[l];
   		    	   }
   		    	   System.out.println("�����������������ǣ�"+sum);
   		 
    }  
	
}
