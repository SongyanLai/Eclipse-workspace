package ������;
import java.util.Scanner;


public class shanjiao {
	public static void panduan1(){
		double a;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ж��������Ƿ������");
		System.out.println("�������һ����");
		double x = scanner.nextInt();
	 	if(x>0) {
			a=x;
		}else {
			System.out.println("����������");
			panduan1();
		}
		
	
	}
	public static void panduan2(){
		double b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ڶ�����");
		double x = scanner.nextInt();
	 	if(x>0) {
			b=x;
		}else {
			System.out.println("����������");
			panduan2();
		}
	
	}
	public static void panduan3(){
		double c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������������");
		double x = scanner.nextInt();
	 	if(x>0) {
			c=x;
		}else {
			System.out.println("����������");
			panduan3();
		}
	
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		panduan1(); 
		panduan2();
		panduan3();
		if(a+b>c&&a+c>b&&c+b>a) {
			System.out.println("�����γ���");
		}else{
			System.out.println("������");
			}
	}
}


