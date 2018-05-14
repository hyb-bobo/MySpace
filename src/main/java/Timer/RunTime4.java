package Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: hyb
 * Date: Created in 2018/5/14 15:43
 */
public class RunTime4 {

    static int i = 0;

    static public class MyTaskA extends TimerTask {

        @Override
        public void run() {
           System.out.println("正常执行了 "+i);

        }
    }

    public static void main(String[] args){
        while (true){
            try {
                i++;
                Timer timer = new Timer();
                MyTaskA myTaskA = new MyTaskA();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStr = "2018-5-14 15:26:30";
                Date parse = dateFormat.parse(dateStr);
                System.out.println("字符串时间 "+parse.toLocaleString() + "当前时间"+new Date().toLocaleString());
                timer.schedule(myTaskA,parse);
                timer.cancel();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
