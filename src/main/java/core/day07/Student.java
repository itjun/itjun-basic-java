package core.day07;

public class Student extends AbstractStudent {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setNmae(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    void study() {
    System.out.println("Student is studying ...");
    }

    @Override
    void sleep() {
    System.out.println("Student is sleepping ..");
    }
}
