package test2;

public class test {

	public static void main(String[] args) {

		 boolean x=true;

		         boolean y=false;

		         short z=42;

		            if((z++==42)&&  (y=true))z++;  
            //此处z先判断，再自增一次z=43 故true&&true  z再次自增一次，z=44    
		            if((x=false)  ||    (++z==45))  z++;
           // 此处z先自增再判断，z=45，故false||true z再次自增一次，z=46
		           System. out.println(z);
	}

}
