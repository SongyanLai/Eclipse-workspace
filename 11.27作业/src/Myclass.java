class Student {
    static String schoolname;
    protected String name;
    protected int age;

    public Student() {
        System.out.println("--student");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("叫" + name + "，今年" + age + "岁");
    }
}

class Undergradutate extends Student {
    private String degree;

    public Undergradutate(String name, int age,String degree) {
        super(name,age);
        //this.name = name;
        //this.age = age;
        this.degree = degree;
    }

    void introduce() {
        System.out.println("我叫" + name + "，今年" + age + "岁"+"，读" + schoolname + degree);
    }
}

public class Myclass {
    public static void main(String[] args) {
       Student.schoolname = "杭州职业技术学院";

       Student a1 = new Student("张三",18);
       a1.introduce();

       Undergradutate a2 = new Undergradutate("张三",18,"专科");
       a2.introduce();
    }
}

