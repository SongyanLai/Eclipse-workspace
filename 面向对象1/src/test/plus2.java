package test;

public class plus2 {
	public static long plusa(int a,int n) {
		long num1 = a;//ÿ������
		long num2 = 0;//��
		//ѭ����
		for(int i = 0;i < n;i++) {
			System.out.println(num1 + "+");
			num2 += num1;
			//�ı����
			num1 *= 10;
			num1 += a;
		}
		return num2;
	}

}
