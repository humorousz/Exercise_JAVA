package chapter.five.reflection;



import java.lang.reflect.*;
import java.util.Scanner;

/**
 * Created by zzq on 17-4-24.
 */
public class ReflectioinTest {
    public static void main(String[] args){
        String name ;
        if(args.length>0){
            name = args[0];
        }else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date)");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers+" ");
            }
            System.out.print("class"+ name);
            if(superCl != null && superCl!= Object.class)
                System.out.print(" extends "+superCl.getName());
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethords(cl);
            System.out.println();
            printFields(cl);
            System.out.println();
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for(Constructor c: constructors){
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0 )
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramsType = c.getParameterTypes();
            for(int i=0;i<paramsType.length;i++){
                if(i > 0)System.out.print(",");
                System.out.print(paramsType[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printMethords(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for(Method m:methods){
            String modifiers = Modifier.toString(m.getModifiers());
            String name = m.getName();
            Class returnType = m.getReturnType();
            System.out.print("  ");
            if(modifiers.length()>0)
                System.out.print(modifiers+" ");
            System.out.print(returnType+" ");
            System.out.print(name+"(");
            Class[] paramsType = m.getParameterTypes();
            for(int i=0;i<paramsType.length;i++){
                if(i>0)
                    System.out.print(",");
                System.out.print(paramsType[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printFields(Class cl){
        Field[] fields= cl.getDeclaredFields();
        for(Field field :fields){
            Class type = field.getType();
            String name = field.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length()>0)
                System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");

        }
    }

}
