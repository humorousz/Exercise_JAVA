package chapter.five.person;

/**
 * Created by zzq on 17-4-18.
 */
public class Student extends Person {
    private String major;

    /**
     *
     * @param name student name
     * @param major student major
     */
    public Student(String name,String major) {
        super(name);
        this.major = major;
    }

    public String getDescription(){
        return "a student majoring in "+ major;
    }


}
