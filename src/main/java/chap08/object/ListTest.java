package chap08.object;

import java.util.ArrayList;

/**
 * Created by iCrazyTeam on 16/6/7.
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Carl", 7500, 2010, 12, 15));
        staff.add(new Employee("Harry", 5500, 2012, 10, 01));
        staff.add(new Employee("Tony", 4000, 2014, 8, 21));

        for (Employee e : staff) {
            e.raiseSalary(50);
        }

        for (Employee e : staff) {
            System.out.println(
                    String.format("Name = %s, Salary = %s, hireDay = %s", e.getName(), e.getSalary(), e.getHireDay()));
        }
    }
}
