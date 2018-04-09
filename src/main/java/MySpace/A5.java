package MySpace;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Author: hyb
 * Date: Created in 2018/4/9 15:57
 */
public class A5 {

    public static void main(String[] args) throws IOException {

        String filePath = "F:/" ;
        File file = new File( filePath ) ;
        getFile(file);

    }


    /**
     * 获取指定目录的所有文件夹
     * @param file
     */
    private static void getFile( File file ){
        MyFileFilter myFileFilter = new MyFileFilter() ;

        File[] files = file.listFiles( myFileFilter ) ;
        for( File f : files ){
            if ( f.isHidden() ) continue ;

            System.out.println( f.getAbsolutePath() );
        }
    }


    static class MyFileFilter implements FileFilter {

        MyFileFilter(){

        }

        //pathname：文件的绝对路径+ 文件名 , 比如：F:\阿刁.mp3  ， 或者： F:\文件夹1
        public boolean accept(File pathname) {
            if( pathname.isDirectory() ){
                return true ;
            }
            return false;
        }

    }

}
