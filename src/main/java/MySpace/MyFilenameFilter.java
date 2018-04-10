package MySpace;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {
    //type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件
    private String type;

    MyFilenameFilter(String type) {
        this.type = type;
    }

    public boolean accept(File dir, String name) {
        //dir表示文件的当前目录，name表示文件名；
        return name.endsWith(type);
    }

    public static void main(String[] args){
        MyFilenameFilter myFilenameFilter = new MyFilenameFilter("jpg");

    }
}
