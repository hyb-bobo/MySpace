package Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: hyb
 * Date: Created in 2018/5/14 15:33
 */
public class RunTime3 {

    /**
     * TimerTask 中的cancel方法是将自身清楚
     * 而Timer 类中的cancel是将整个任务队列中的全部任务清楚
     */
    private static Timer timer = new Timer();
    static public class MyTaskA extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了A 时间为:"+new Date().toLocaleString());
//            this.cancel();
            timer.cancel();

        }
    }

    public static void main(String[] args){
        try {
            MyTaskA myTask = new MyTaskA();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = "2018-5-14 15:26:30";
            Date parse = dateFormat.parse(dateStr);
            System.out.println("字符串时间 "+parse.toLocaleString() + "当前时间"+new Date().toLocaleString());
            timer.schedule(myTask,parse,1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
