package 面向对象1;

class Dog {
	String name;
	private int age;
	String color;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
    void jump(){
    	System.out.println(name+"会跳，今年"+age+"岁");
    }
    
    public void kong() {	
    }
    
    public void fangfa1(String name ,int age){
    	this.name=name;
    	this.age=age;
    }
    
    public void fangfa2(String name ,String color,int age){
    	this.name=name;
    	this.age=age;
    	this.color=color;
    }
    
    
public static class Eg{
    	public static void main(String[]args) {
    		Dog wc = new Dog();
    		wc.name="旺财";
    		wc.age=2;
    		wc.color="黑色";
    		wc.jump();
    		Dog bb = new Dog();
    		bb.name="宝宝";
    		bb.age=5;
    		bb.color="黄色";
    		bb.jump();
    
    	}
}
}


