package �������1;

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
    	System.out.println(name+"����������"+age+"��");
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
    		wc.name="����";
    		wc.age=2;
    		wc.color="��ɫ";
    		wc.jump();
    		Dog bb = new Dog();
    		bb.name="����";
    		bb.age=5;
    		bb.color="��ɫ";
    		bb.jump();
    
    	}
}
}


