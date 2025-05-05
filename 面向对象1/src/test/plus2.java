package test;

public class plus2 {
	public static long plusa(int a,int n) {
		long num1 = a;//每个加数
		long num2 = 0;//和
		//循环加
		for(int i = 0;i < n;i++) {
			System.out.println(num1 + "+");
			num2 += num1;
			//改变加数
			num1 *= 10;
			num1 += a;
		}
		return num2;
	}

}
