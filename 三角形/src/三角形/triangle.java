package 三角形;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class triangle {
	public static int InputValue() {
		String a;
		Scanner scanner = new Scanner(System.in);

		boolean rs1 = true;
		String x;
		System.out.println("请输入:");
		do {
			x = scanner.next();
			String regEx = "[\\d]+\\.[\\d]+";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(x);
			rs1 = matcher.matches();
			if (rs1 == false)
				System.out.println("请重新输入:");
		} while (rs1 == false);

		return Integer.parseInt(x);
	}

	public static void main(String[] args) {

		System.out.println("判断三角形是否成立：");

		int a = InputValue();
		int b = InputValue();
		int c = InputValue();

		if (a + b > c && a + c > b && c + b > a) {
			System.out.println("三角形成立");
		} else {
			System.out.println("三角形不成立");
		}
	}
}
