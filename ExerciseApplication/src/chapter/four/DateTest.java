package chapter.four;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by zhangzhiquan on 2017/4/8.
 * Java核心卷 101p-102p
 */
public class DateTest {

    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //往前挪动today-1天 例如8号 挪动7天
        date =  date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();


        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++) {
            System.out.print("   ");
        }

        //每次循环结束date.plusDays(1) 当date不是当前月份时  循环结束
        while(date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1)System.out.println();
        }
    }

}
