package 面向对象1;

public class Eg{
	public static void main(String[]args) {
		Dog hf = new Dog();
		hf.name="黄蜂";
		hf.age=17;
		hf.color="黄色";
		
		hf.jump();
		
		Dog xa = new Dog();
		xa.name="许安";
		xa.age=18;
		
		xa.jump();
	}
}