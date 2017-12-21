package jvmtest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangzhiquan on 2017/12/20.
 * @author zhangzhiquan
 */
public class ThreadPoolTest {
    private ThreadPoolExecutor pool = null;

    public void init(){
        pool = new ThreadPoolExecutor(1,
                2,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new TestThreadFactory(),
                new TestRejectedExecutionHandler());
    }

    public void destory(){
        if(pool != null){
            pool.shutdown();
        }
    }

    public ExecutorService getTestThreadPoolExecutor() {
        return this.pool;
    }


    public static class TestThreadFactory implements ThreadFactory{
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = ThreadPoolTest.class.getSimpleName() + count.addAndGet(1);
///            System.out.println(threadName);
            t.setName(threadName);
            return t;
        }
    }

    public static class TestRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//            // 记录异常
//            // 报警处理等
///            System.out.println("error.............");
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 测试构造的线程池
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolTest exec = new ThreadPoolTest();
        // 1.初始化
        exec.init();

        ExecutorService pool = exec.getTestThreadPoolExecutor();
        int count = 10;
        for (int i = 1; i < count; i++) {
            System.out.println("提交第" + i + "个任务!");
            final int pos = i;
            pool.execute(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(pos+" 执行完成");
            });
        }



        // 2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了
        // exec.destory();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
