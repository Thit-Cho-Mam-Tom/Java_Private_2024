import java.util.Scanner;

public class Student extends Person{
    private int id;
    private String nameClass;
    private float gpa;
    private final float criteria = 2;

    public Student() {
      super();
    }

    public Student(String name, int age, Address address, int id, String nameClass, float gpa) {
        super(name, age, address);
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public float getCriteria() {
        return criteria;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nameClass='" + nameClass + '\'' +
                ", gpa=" + gpa +
                ", criteria=" + criteria +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập id: ");
        this.id=sc.nextInt();
        sc.nextLine();
        super.input();
        System.out.println("nhập class name: ");
        this.nameClass = sc.nextLine();
        System.out.println("nhập gpa: ");
        this.gpa= sc.nextFloat();
        sc.nextLine();
    }
    public void output(){
        super.output();
        System.out.printf("%-15d %-15s %15.2f \n", this.id, this.nameClass, this.gpa);
    }
    public boolean checkFail(){
        if(gpa < criteria) return true;
        return false;
    }
}
