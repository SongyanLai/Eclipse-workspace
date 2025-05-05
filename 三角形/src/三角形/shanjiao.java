package 三角形;
import java.util.Scanner;


public class shanjiao {
	public static void panduan1(){
		double a;
		Scanner scanner = new Scanner(System.in);
		System.out.println("判断三角形是否成立：");
		System.out.println("请输入第一个数");
		double x = scanner.nextInt();
	 	if(x>0) {
			a=x;
		}else {
			System.out.println("请重新输入");
			panduan1();
		}
		
	
	}
	public static void panduan2(){
		double b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第二个数");
		double x = scanner.nextInt();
	 	if(x>0) {
			b=x;
		}else {
			System.out.println("请重新输入");
			panduan2();
		}
	
	}
	public static void panduan3(){
		double c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第三个数");
		double x = scanner.nextInt();
	 	if(x>0) {
			c=x;
		}else {
			System.out.println("请重新输入");
			panduan3();
		}
	
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		panduan1(); 
		panduan2();
		panduan3();
		if(a+b>c&&a+c>b&&c+b>a) {
			System.out.println("三角形成立");
		}else{
			System.out.println("不成立");
			}
	}
}


