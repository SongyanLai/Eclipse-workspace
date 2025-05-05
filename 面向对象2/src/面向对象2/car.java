package 面向对象2;


class Car {
	private int speed = 0;
	boolean on = false;
	double weight = 1.2;
	String color = "blue";
	
	public void setSpeed(int speed) {
		if(speed < 0 || speed > 220) {
			System.out.println("非法数值");
		}else {
			this.speed=speed;
		}
	}
	
	public Car() {
	}
	
	public Car(int speed,double weight) {
		this.speed=speed;
		this.weight=weight;
	}
	public Car(int speed,double weight,boolean on,String color) {
		this.speed=speed;
		this.weight=weight;
		this.on=on;
		this.color=color;
	}
 public void display () {
		if(on == true) {
			System.out.println(speed);
			System.out.println(color);
			System.out.println(weight);
		}else {
			System.out.println("car is off");
			System.out.println(color);
			System.out.println(weight);
			
		}
	}
 public static void main(String[]args) {
	  Car car1= new Car(120,1.5,true,"black");
//	  Car1.speed=120;
//	  Car1.weight=1.5;
//	  Car1.color="black";
//	  Car1.on=true;
	  car1.display();
	  
	  Car car2= new Car(0,1.2,false,"red");
//	  Car2.speed=0;
//	  Car2.weight=1.2;
//	  Car2.color="red";
//	  Car2.on=false;
	  car2.display();
 }


}
