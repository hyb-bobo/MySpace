package Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: hyb
 * Date: Created in 2018/5/14 14:46
 */
public class RunTime {

    private static Timer timer = new Timer();
    static public class MyTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("运行了 时间为:"+new Date().toLocaleString());

        }
    }
    public static void main(String[] args){
        try {
            MyTask myTask = new MyTask();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = "2018-5-14 15:11:00";
            Date parse = dateFormat.parse(dateStr);
            System.out.println("字符串时间 "+parse.toLocaleString() + "当前时间"+new Date().toLocaleString());
            timer.schedule(myTask,parse);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
