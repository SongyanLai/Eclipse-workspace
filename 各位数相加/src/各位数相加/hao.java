package ��λ�����;
import java.util.Scanner;
public class hao {

	public static void main(String[] args) {
		System.out.println("������һ����");
		Scanner scanner = new Scanner (System.in);
		int a;
		a = scanner.nextInt();
		int b , c , d , e ,f;
		b=a/1000;
		c=a%1000/100;
		d=a%100/10;
		e=a%10;
		System.out.println("����λ����֮��Ϊ");
		System.out.println(b+c+d+e);
	}

}
