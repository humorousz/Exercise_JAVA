package algorithmJava;

/**
 * Created by zhangzhiquan on 2017/11/19.
 * {@link #permute(String)}
 * {@link #permute(char[], int, int)}
 * 第一个例程是个驱动程序，它调用第二个例程并显示String str中的字符所有排列。如果str是'abc'，那么输出的串则是
 * abc,acb,bac,bca,cba和cab。第二个例程使用递归。
 */
public class ChapterOne6 {


    public void permute(String str){
        permute(str.toCharArray(),0,str.length());
    }

    private void permute(char[] str,int low,int high){
        if(low >= high){
            System.out.print(String.valueOf(str));
            System.out.print(",");
            return;
        }
        for (int i = low ; i < high ;i++){
            swap(str,low,i);
            permute(str,low+1,high);
            swap(str,low,i);
        }

    }

    private void swap(char[] str,int a,int b){
        if(a == b)
            return;
        char tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }

    public static void  main(String[] args){
        String a = "abc";
        ChapterOne6 chapterOne6 = new ChapterOne6();
        chapterOne6.permute(a);
    }
}
