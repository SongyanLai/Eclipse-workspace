package ����;
import java.util.Scanner;
public class ��ֵ3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double arr []= new double [10];
		for(int l = 0; l<arr.length; l++){
			 System.out.print(arr[l]+"\t");
			 }

	         double max=arr[0];
	         double min=arr[0];
	         int sum=0;
			 //�󔵽M���ֵ
			 for(int i=0; i<arr.length;i++){
			 if(arr[i]>max) max=arr[i];
			 }
			 System.out.println("\n������������������ֵ�ǣ�"+max);
			 //�󔵽M��Сֵ
			 for(int j = 0; j<arr.length;j++){
			 if(arr[j]<min)min=arr[j];
			 }
			 System.out.println("�����������������Сֵ�ǣ�"+min);
			//�󔵽M��ƽ��ֵ
			       for(int k = 0; k<arr.length; k++){
			   sum+=arr[k];
			       }
			       int avg=sum/arr.length;
			       System.out.println("����������������ƽ��ֵ�ǣ�"+avg);
			//���
			       for(int l = 0; l < arr.length; l ++){

			    	   sum += arr[l];
			    	   }
			    	   System.out.println("�����������������ǣ�"+sum);
			 
		}
	
}

System.out.println("max="+max);
System.out.println("min="+min);
System.out.println("���ǵĺ���"+d);
System.out.println("���ǵ�ƽ������"+(d/arr.length));
	}

	}
