import java.util.Scanner;
public class buhao {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	        System.out.print("����0 ~ 1000����������") ;

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
	        System.out.println(number + " ÿλ�ĺ�Ϊ " + meiweihe);
	}

}