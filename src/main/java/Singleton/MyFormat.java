package Singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: hyb
 * Date: Created in 2018/5/15 16:19
 */
public class MyFormat extends Thread {

    private SimpleDateFormat sdf;
    private String dateString;
    public MyFormat(SimpleDateFormat sdf,String dateString){
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date parse = sdf.parse(dateString);
            String newDateString = sdf.format(parse).toString();
            if(!newDateString.equals(dateString)){
                System.out.println("ThreadName "+this.getName()
                +"报错了  日期字符串"+dateString+
                "转换成的日期字符串"+newDateString);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
