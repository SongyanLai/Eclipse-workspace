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
        System.out.println("��" + name + "������" + age + "��");
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
        System.out.println("�ҽ�" + name + "������" + age + "��"+"����" + schoolname + degree);
    }
}

public class Myclass {
    public static void main(String[] args) {
       Student.schoolname = "����ְҵ����ѧԺ";

       Student a1 = new Student("����",18);
       a1.introduce();

       Undergradutate a2 = new Undergradutate("����",18,"ר��");
       a2.introduce();
    }
}

