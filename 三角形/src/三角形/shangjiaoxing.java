package ������;

import java.util.Scanner;

public class shangjiaoxing {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		double a=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ж��������Ƿ������");
		System.out.println("�������һ����");
		double x = scanner.nextInt();
	 	if(x>0) {
			a=x;
		}else {
			System.out.println("����������");
		}
		double b=0;
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("������ڶ�����");
		double y = scanner.nextInt();
	 	if(x>0) {
			b=y;
		}else {
			System.out.println("����������");
		}
	 	double c=0;
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("�������������");
		double z = scanner.nextInt();
	 	if(x>0) {
			c=z;
		}else {
			System.out.println("����������");
		}
	 	
		if(a+b>c&&a+c>b&&c+b>a) {
			System.out.println("�����γ���");
		}else{
			System.out.println("������");
			}
	}

}
