import java.util.Scanner;
public class buhao {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	        System.out.print("输入0 ~ 1000的任意整数") ;

	        @SuppressWarnings("resource")
			int number = new Scanner(System.in).nextInt();
	        int baiwei_houmianshi0 = number % 1000;
	        int shiwei_houmianshi0 = number % 100;
	        int gewei_houmianshi0 = number % 10;

	        int qianwei = number / 1000;
	        int baiwei = baiwei_houmianshi0 / 100;
	        int shiwei = shiwei_houmianshi0 / 10;
	        int gewei = gewei_houmianshi0 / 1;

	        int meiweihe = qianwei + baiwei + shiwei +gewei;
	        System.out.println(number + " 每位的和为 " + meiweihe);
	}

}