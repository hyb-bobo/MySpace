package MySpace;

import java.io.File;
import java.io.IOException;

/**
 * Author: hyb
 * Date: Created in 2018/4/9 15:54
 */
public class A4 {

        public static void main(String[] args) throws IOException {

            String filePath = "F:/" ;
            File file = new File( filePath ) ;
            getFile(file);

        }

        private static void getFile( File file ){
            File[] files = file.listFiles() ;
            for( File f : files ){
                if ( f.isHidden() ) continue ;

                if(f.isDirectory() ){
                    getFile( f );
                }else{
                    System.out.println( f.getAbsolutePath()  + "  " + f.getName() );
                }
            }
        }
}
