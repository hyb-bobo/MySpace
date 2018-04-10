package MySpace;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Author: hyb
 * Date: Created in 2018/4/9 16:09
 */
public class A6 {

    public static void main(String[] args) throws IOException {

        String filePath = "D:/" ;
        File file = new File( filePath ) ;
        getFile(file);

    }


    /**
     * 扫描出指定路径的所有图片
     * @param file
     */
    private static void getFile( File file ){
        MyFilenameFilter myFileFilter = new MyFilenameFilter( ".png") ;

        File[] files = file.listFiles( myFileFilter ) ;
        for( File f : files ){
            if ( f.isHidden() ) continue ;

            System.out.println( f.getAbsolutePath() );
        }
    }



    static class MyFilenameFilter implements FilenameFilter {
        //type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件
        private String type;
        MyFilenameFilter( String type){
            this.type = type ;
        }

        public boolean accept(File dir, String name) {
            //dir表示文件的当前目录，name表示文件名；
            return name.endsWith( type ) ;
        }

    }

}
