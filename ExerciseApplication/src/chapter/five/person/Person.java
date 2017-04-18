package chapter.five.person;

/**
 * Created by zzq on 17-4-18.
 */
public abstract class Person {
    private String name;
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}
