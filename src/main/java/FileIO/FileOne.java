package FileIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Author: hyb
 * Date: Created in 2018/4/10 8:51
 */
public class FileOne {

    public static void main(String[] args) {
       /* String filePath1 = "D:\\ps_log" ;
        File file1 = new File( filePath1 ) ;

        String filePath2 = "D:\\ps_log" ;
        File file2 = new File( filePath2 ) ;

        try {
            //复制文件夹
            FileUtils.copyDirectory( file1 , file2 );
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        getFile();
    }

    public static void getFile(){
        String url = "https://blog.csdn.net/zhaoyanjun6/article/details/54972773" ;

        String filePath2 = "D:/abc.html" ;
        File file2 = new File( filePath2 ) ;

        try {

            //把服务器上图片下载到本地F盘的abc.jpg图片
            FileUtils.copyURLToFile( new URL( url ) , file2 );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
