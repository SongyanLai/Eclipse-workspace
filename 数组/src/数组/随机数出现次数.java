package 数组;

public class 随机数出现次数 {

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

