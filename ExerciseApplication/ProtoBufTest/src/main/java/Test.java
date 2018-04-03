import com.google.protobuf.InvalidProtocolBufferException;
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
        System.out.println("===========Person Byte==========");
        for(byte b : person.toByteArray()){
            System.out.print(b);
        }
        System.out.println();
        System.out.println(person.toByteString());
        System.out.println("================================");

        //模拟接收Byte[]，反序列化成Person类
        byte[] byteArray =person.toByteArray();
        PersonInfo.Person p2 = null;
        try {
            p2 = PersonInfo.Person.parseFrom(byteArray);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println("after :" +p2.toString());
    }
}
