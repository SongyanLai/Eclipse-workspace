package 数组;

public class 出现次数 {

	public static void main(String[] args) {
		int a[]=new int[100];
		int counts[]=new int[10];
		for (int i=0;i<a.length;i++){
			a[i]=(int)(Math.random()*10);
			counts[a[i]]++;
			}
		System.out.println("0出现的次数:"+counts[0]);
		System.out.println("1出现的次数:"+counts[1]);
		System.out.println("2出现的次数:"+counts[2]);
		System.out.println("3出现的次数:"+counts[3]);
		System.out.println("4出现的次数:"+counts[4]);
		System.out.println("5出现的次数:"+counts[5]);
		System.out.println("6出现的次数:"+counts[6]);
		System.out.println("7出现的次数:"+counts[7]);
		System.out.println("8出现的次数:"+counts[8]);
		System.out.println("9出现的次数:"+counts[9]);

	}

}
