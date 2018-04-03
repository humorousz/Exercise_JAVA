import main.java.PersonInfo;

/**
 * Created by zhangzhiquan on 2018/4/3.
 */
public class Test {
    public static void main(String[] args){
        PersonInfo.Person person= PersonInfo.Person.newBuilder()
                .setId(1)
                .setName("zz")
                .setEmail("dddd").build();

        System.out.println(person);

    }
}
