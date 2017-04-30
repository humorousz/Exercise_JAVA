package chapter.five.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhangzhiquan on 2017/4/30.
 */
public class CopyOfTest {


    public static void main(String[] args){
        int[] a={1,2,3};
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b = new String[]{"Tom","Dick","Harry"};
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception");
        b = (String[]) badCopyOf(b,10);
    }

    /**
     * This method attempts to grow an array by allocating a new array and copying all elements
     * @param a
     * @param newLength
     * @return a larger array that contains all elements of a. However, the returned array has type Object[],not the
     * same type as a
     */
    public static Object[] badCopyOf(Object[] a, int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }

    /**
     * This method grows an array by allocating a new array of the same type and copying all elements.
     * @param a
     * @param newLength
     * @return a larger array that contains all elements of a.
     */
    public static Object goodCopyOf(Object a,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray())
            return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,length);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
