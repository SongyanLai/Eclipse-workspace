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

System.out.println("����һ��������,�߳���"+((Square)an).a);

}

if(an instanceof Circlre){

System.out.println("����һ��Բ����,�뾶��"+((Circlre)an).r);

}

System.out.println("�����"+an.getArea());

}

public static void main(String[] args) {

Square a=new Square(2);

Circlre b=new Circlre(3);

jisuan(a);

jisuan(b);


}

 }

