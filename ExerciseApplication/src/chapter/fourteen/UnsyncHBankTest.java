package chapter.fourteen;

/**
 * Created by zhangzhiquan on 2017/7/8.
 */
public class UnsyncHBankTest {
    public static final int NACCCOUNTS = 100;
    public static final double INTTIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args){
        Bank bank = new Bank(NACCCOUNTS,INTTIAL_BALANCE);
        for(int i = 0; i < NACCCOUNTS; i++){
            int fromAccount = i;
            Runnable r = ()->{
              try {
                  while (true){
                      int toAccount = (int)(bank.size() * Math.random());
                      double amount = MAX_AMOUNT * Math.random();
                      bank.transfer(fromAccount,toAccount,amount);
                      Thread.sleep((long) (DELAY * Math.random()));
                  }
              }catch (InterruptedException e){

              }
            };

            Thread t = new Thread(r);
            t.start();
        }
    }
}
