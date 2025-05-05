package ì³²¨ÄÇÆõÊýÁÐ;

	public class fibos {
		static int fibonacci2(int n) {
		if (n==1 || n==2) {
			return 1;
		}else if(n>2) {
			return fibonacci2(n-2) + fibonacci2(n-1);
		}else{
			return - 1;
		}
	}
		static void fibos(int n) {
			for (int i = 1; i <= n; i++) {
				System.out.println(fibonacci2(i)+" ");
			}
		}
}
