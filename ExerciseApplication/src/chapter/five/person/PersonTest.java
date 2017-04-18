package chapter.five.person;

import java.time.LocalDate;

/**
 * Created by zzq on 17-4-18.
 */
public class PersonTest  {

    public static void main(String[] args){
        Person[]  people = new Person[2];

        people[0] = new Employee("Harry Hacker",50000,2017,4,18);
        people[1] = new Student("Maria Morris","computer science");

        for(Person p:people){
            System.out.println(p.getName()+", "+p.getDescription());
        }

        String s ="OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() +" "+ sb.hashCode());

        String t = new String("OK");
        StringBuilder tb = new StringBuilder(s);
        System.out.println(t.hashCode() +" "+ tb.hashCode());

        System.out.println(sb.equals(tb));//false

        Employee e1 =new Employee("Harry Hacker",50000,2017,4,18);
        Employee e2 =new Employee("Harry Hacker",50000,2017,4,18);

        System.out.println("e1 == e2 ?"+e1.equals(e2));//true
        System.out.println("e1:"+e1.hashCode());//same
        System.out.println("e2:"+e2.hashCode());

        LocalDate date1 = LocalDate.of(1992,10,20);
        LocalDate date2 = LocalDate.of(1992,10,20);

        System.out.println("date1 == date2 ?"+date1.equals(date2));//true
        System.out.println("date1:"+date1.hashCode());//same
        System.out.println("date2:"+date2.hashCode());
    }

    /**
     * equals 需要满足几个条件
     * 自反性：对于任何非空引用x,x.equals(x)应该返回true
     * 对称性：对于任何引用x和y,当切仅当y.equals(x)返回true,x.equals(y)也应当返回true
     * 传递性：对于任何引用x,y,z,如果x.equals(y)返回true,y.equals(z)返回true,x.equals(z)也应该返回true
     * 一致性：如果x和y引用的对象没有发生变化,反复调用x.equals(y)应该返回同样的结果
     * 对于任意非空的引用x,x.equals(null)应该返回false
     */

    /**
     * 复写equals必须复写hashCode,因为相等的对象要有相同的hash值
     */
}
