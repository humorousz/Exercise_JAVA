package chapter.eight;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzq on 17-6-13.
 */
public class ListTest {

    public static void main(String[] args){
        Pair<? extends A> pair = new Pair<B>();
    }



    private static class A{

    }

    private static class B extends A{

    }

    private static class Pair<T extends A >{

    }
}
