package ��������;
import java.util.Random;
import java.util.Scanner;

public class abc {

	public static void main(String[] args) {
		double x=0;
		double y=0;
		
		Random rdm=new Random();
		x=Math.abs(rdm.nextInt())%100+1;
		System.out.println(x);
		Random rdm2=new Random();
		y=Math.abs(rdm2.nextInt())%100+1;
		System.out.println(y);
		System.out.println("������������ӵĴ�");
		Scanner scanner =new Scanner(System.in);
		int a = scanner.nextInt();
		if(a==x+y)
			System.out.println("������ȷ");
			else
			System.out.println("�������");

	}

}
