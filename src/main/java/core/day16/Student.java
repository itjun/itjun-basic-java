package core.day16;

public class Student implements Comparable<Student> {
    private String roomName;
    private String name;
    private int age;

    Student(String roomName, String name) {
        this.roomName = roomName;
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        int num = new Integer(this.age).compareTo(new Integer(s.age));

        if (num == 0)
            return this.name.compareTo(s.name);
        return num;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 34;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            throw new ClassCastException("类型不匹配");

        Student s = (Student) obj;

        return this.name.equals(s.name) && this.age == s.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}