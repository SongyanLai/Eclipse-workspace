package ����;

import java.util.Scanner;
import java.util.Random;

public class ��ֵ {

	public static void main(String[] args) {
		
		//���������ж�����������Ϊ10�����飬ͨ�������������������ַ�ʽ���и�ֵ�����ֱ�������������е����Ԫ�ء���СԪ�ء�ƽ��ֵ���͡�
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
    		 //�󔵽M���ֵ
    		 for(int i=0; i<number.length;i++){
    			 if(number[i]>max) max=number[i];
    		 }
    		 System.out.println("\n������������������ֵ�ǣ�"+max);
    		 //�󔵽M��Сֵ
    		 for(int j = 0; j<number.length;j++){
    			 if(number[j]<min)min=number[j];
    		 }
    		 System.out.println("�����������������Сֵ�ǣ�"+min);
    		//�󔵽M��ƽ��ֵ
    		       for(int k = 0; k<number.length; k++){
    		   sum+=number[k];
    		       }
    		       int avg=sum/number.length;
    		       System.out.println("����������������ƽ��ֵ�ǣ�"+avg);
    		//���
    		       for(int l = 0; l < number.length; l ++){

    		    	   sum += number[l];
    		    	   }
    		    	   System.out.println("�����������������ǣ�"+sum);
    		 
     }
     
	

	}

         

     }

     
     

     
     
