package 三角形;

import java.util.Scanner;

public class shangjiaoxing {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		double a=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("判断三角形是否成立：");
		System.out.println("请输入第一个数");
		double x = scanner.nextInt();
	 	if(x>0) {
			a=x;
		}else {
			System.out.println("请重新输入");
		}
		double b=0;
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("请输入第二个数");
		double y = scanner.nextInt();
	 	if(x>0) {
			b=y;
		}else {
			System.out.println("请重新输入");
		}
	 	double c=0;
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("请输入第三个数");
		double z = scanner.nextInt();
	 	if(x>0) {
			c=z;
		}else {
			System.out.println("请重新输入");
		}
	 	
		if(a+b>c&&a+c>b&&c+b>a) {
			System.out.println("三角形成立");
		}else{
			System.out.println("不成立");
			}
	}

}
