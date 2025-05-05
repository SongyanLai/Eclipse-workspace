package нд╪Ч;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class zy {

	public static void main(String[] args) throws IOException {  

	      FileReader fr = new FileReader("xxx.txt");   

	      FileWriter fw = new FileWriter("zzz.txt");    

	      int c;   

	      while((c = fr.read()) != -1) {    

	         fw.write();                

	      }      

	      fr.close();  

	      fw.close();    

	   }

}
