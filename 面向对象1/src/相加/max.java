package 相加;

	import java.util.Scanner;

	public class max {

		public static void main(String args[]){

			Scanner input=new Scanner (System.in);

			System.out.println("请输入一个0-9的数字");

			int x=input.nextInt();

			a(x);


		}

		public static  long a(long x) {


			long num1=x;

			long sum=0;

			long sum1=0;

			x=x+x*10;

			for(int i=1;i<10;i++){

				sum=sum*10+num1;

				System.out.print(sum+"+");

				sum1=sum1+sum;

			}
			
			long k=sum*10+num1;

			System.out.print(k);

			sum1=sum1+k;

			System.out.println("=");

			System.out.println(sum1);

			return sum1;

		}



	}

