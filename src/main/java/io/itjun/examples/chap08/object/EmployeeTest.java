package io.itjun.examples.chap08.object;

/**
 * Created by itjun on 2016/6/1 0001.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee item = new Employee();
        item.setName("Jenkins");
        item.setSalary(200);
        System.out.println(item.getName() + "," + item.getSalary());
        System.out.println(triple(3));
    }

    public static int triple(int x) {
        x += 3;
        return x;
    }
}