package io.itjun.examples.chap08.object;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by iCrazyTeam on 16/5/31.
 */
public class Employee {
    private String name;
    private Date hireDay;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calentar = new GregorianCalendar(year, month - 1, day);
        hireDay = calentar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
