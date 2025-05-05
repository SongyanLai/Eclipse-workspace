package 相加;
import java.util.Scanner;
public class plus {
	public static void main(String args[]){
		  System.out.println("请输入原始的数字");
		  Scanner scanner = new Scanner(System.in);
		  int x = scanner.nextInt();
		  System.out.println("请输入要相加的个数");
		  int y = scanner.nextInt();
		  a(x, y);
		
	}
		
			
			public static long a(long a,long n) {
				long num1 = a;
				long num2 = 0;
				for(int i = 0;i < n;i++) {
					System.out.println(num1 + num2);
					num2 += num1;
					num1 *= 10;
					num1 += a;
				}
				return num2;
			}

			

}
