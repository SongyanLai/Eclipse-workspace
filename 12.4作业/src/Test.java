interface Shape {
	double getArea();
}

class Square implements Shape{

	double a;

	Square(){
	}

	Square(double a){

		this.a=a;

	}

@Override

public double getArea() {

return a*a;

}



}

 

 class Circlre implements Shape{

double r;

Circlre(){


}

Circlre(double r){

this.r=r;

}

@Override

public double getArea() {

return 6.28*r;

}



}

 

 class Test{

public static void jisuan(Shape an){

if(an instanceof Square){

System.out.println("这是一个正方形,边长是"+((Square)an).a);

}

if(an instanceof Circlre){

System.out.println("这是一个圆形形,半径是"+((Circlre)an).r);

}

System.out.println("面积是"+an.getArea());

}

public static void main(String[] args) {

Square a=new Square(2);

Circlre b=new Circlre(3);

jisuan(a);

jisuan(b);


}

 }

