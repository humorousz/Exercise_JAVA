import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by zhangzhiquan on 2019/8/4.
 */
public class BCryptUtil {
    public static String encode(String password){
        //对明文密码进行加密,并返回加密后的密码
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    //将明文密码跟加密后的密码进行匹配，如果一致返回true,否则返回false
    public static boolean match(String password, String encodePassword){
        return BCrypt.checkpw(password,encodePassword);
    }

    public static void main(String[] args){
        String password = "quan1918";     //明文密码
        String psd = BCryptUtil.encode(password);
        System.out.println(psd);            //如果一致，返回true，否则返回false
    }
}
