package test2;

public class test {

	public static void main(String[] args) {

		 boolean x=true;

		         boolean y=false;

		         short z=42;

		            if((z++==42)&&  (y=true))z++;  
            //�˴�z���жϣ�������һ��z=43 ��true&&true  z�ٴ�����һ�Σ�z=44    
		            if((x=false)  ||    (++z==45))  z++;
           // �˴�z���������жϣ�z=45����false||true z�ٴ�����һ�Σ�z=46
		           System. out.println(z);
	}

}
