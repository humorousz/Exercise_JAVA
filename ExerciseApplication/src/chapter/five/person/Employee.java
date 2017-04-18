package chapter.five.person;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by zzq on 17-4-18.
 */
public class Employee extends Person {
    private double salary;
    private LocalDate hireDay;
    public Employee(String name,double salary,int year,int month,int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription(){
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise;
    }

    @Override
    public boolean equals(Object obj) {
        /**
         * equals 需要满足几个条件
         * 自反性：对于任何非空引用x,x.equals(x)应该返回true
         * 对称性：对于任何引用x和y,当切仅当y.equals(x)返回true,x.equals(y)也应当返回true
         * 传递性：对于任何引用x,y,z,如果x.equals(y)返回true,y.equals(z)返回true,x.equals(z)也应该返回true
         * 一致性：如果x和y引用的对象没有发生变化,反复调用x.equals(y)应该返回同样的结果
         * 对于任意非空的引用x,x.equals(null)应该返回false
         */
        //a quick test to see if the objects are identical
        if(this == obj)return true;
        if(obj == null)return false;
        if(getClass() != obj.getClass())return  false;

        Employee other = (Employee) obj;

        return  getName().equals(other.getName()) && salary == other.getSalary() && hireDay.equals(other.getHireDay());
    }

    @Override
    public int hashCode() {
        return 7*getName().hashCode() + 11*Double.hashCode(salary) + 13* Objects.hashCode(hireDay);
    }
}
