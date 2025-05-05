package class1;

class 英里转换成千米 {

	public static void main(String[] args) {
		System.out.println("千米"+"\t"+"英里");
		int km =1;
		double mile = 0.0;
	while(km<=10) {
		mile = km * 1.609;
		System.out.println();
		System.out.println(km+"\t"+mile);
		
		km++;
		
	}
	}

}
