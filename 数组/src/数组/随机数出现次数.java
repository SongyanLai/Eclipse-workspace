package ����;

public class ��������ִ��� {

	public static void main(String[] args) {
		int counts[]=new int[10];
		int i=1;
		while(i<=100){
			int a=(int)(Math.random()*10);
			if(a==0){
				counts[0]+=1;
			}else if(a==1){
				counts[1]+=1;
			}else if(a==2){
				counts[2]+=1;
			}else if(a==3){
				counts[3]+=1;
			}else if(a==4){
				counts[4]+=1;
			}else if(a==5){
				counts[5]+=1;
			}else if(a==6){
				counts[6]+=1;
			}else if(a==7){
				counts[7]+=1;
			}else if(a==8){
				counts[8]+=1;
			}else if(a==9){
				counts[9]+=1;
			}
			i++;
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

