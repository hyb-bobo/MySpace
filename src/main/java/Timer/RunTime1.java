package Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: hyb
 * Date: Created in 2018/5/14 15:01
 */
public class RunTime1 {

    /**
     * task 是将执行的任务放入到队列中，一个一个的进行的
     */
    private static Timer timer = new Timer();

    static public class MyTask1 extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了A 时间为:" + new Date().toLocaleString());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行了A 时间为:" + new Date().toLocaleString());

        }
    }

    static public class MyTask2 extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了B 时间为:" + new Date().toLocaleString());

        }
    }

    public static void main(String[] args){
        try {
            MyTask1 myTask1 = new MyTask1();
            MyTask2 myTask2 = new MyTask2();

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr1 = "2018-5-14 15:18:00";
            String dateStr2 = "2018-5-14 15:18:14";
            Date parse1 = dateFormat1.parse(dateStr1);
            Date parse2 = dateFormat1.parse(dateStr2);
            System.out.println("字符串时间 "+parse1.toLocaleString() + "当前时间"+new Date().toLocaleString());
            System.out.println("字符串时间 "+parse2.toLocaleString() + "当前时间"+new Date().toLocaleString());
            timer.schedule(myTask1,parse1);
            timer.schedule(myTask2,parse2);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
