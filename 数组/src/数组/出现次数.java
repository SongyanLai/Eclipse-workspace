package ����;

public class ���ִ��� {

	public static void main(String[] args) {
		int a[]=new int[100];
		int counts[]=new int[10];
		for (int i=0;i<a.length;i++){
			a[i]=(int)(Math.random()*10);
			counts[a[i]]++;
			}
		System.out.println("0���ֵĴ���:"+counts[0]);
		System.out.println("1���ֵĴ���:"+counts[1]);
		System.out.println("2���ֵĴ���:"+counts[2]);
		System.out.println("3���ֵĴ���:"+counts[3]);
		System.out.println("4���ֵĴ���:"+counts[4]);
		System.out.println("5���ֵĴ���:"+counts[5]);
		System.out.println("6���ֵĴ���:"+counts[6]);
		System.out.println("7���ֵĴ���:"+counts[7]);
		System.out.println("8���ֵĴ���:"+counts[8]);
		System.out.println("9���ֵĴ���:"+counts[9]);

	}

}
