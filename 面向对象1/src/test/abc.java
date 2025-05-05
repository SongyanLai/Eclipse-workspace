package test;

public class abc{
	public static void main(String args[]){
		draw(2,3);
		int u=jc(7);
		System.out.println(u);
		int v=max(2,3);
		System.out.println(v);
	}
	public static void draw(int hight,int width){
		for (int i=0; i<hight; i++){
			for (int j=0; j < width;j++){
				System.out.print("*");    
			}
			System.out.print("\n"); 
		}
	}
	
	public static int getArea(int x,int y){
		int area=x*y;
		return area;
	}
	public static  int jc(int n){
		int b = 1;
		for (int i = 1; i <= n ; i++) {
			b = b * i;
			
		}
		return b;
	}
	public static int max(int x,int y){
		if(x>y)
			return x;
		return y;
	}
	public static double max(double x,double y){
		if(x>y)
			return x;
		return y;
	}
	public static int max(int x,int y,int z){
		if(x>y & x>z)
			return x;
		else if(y>x & y>z)
		 	return y;
		else
			return z;
	}
}
