package MySpace;

import java.io.*;

public class A1 {

    public static void main(String[] args) {
        A1 a1 = new A1();

        //电脑d盘中的abc.txt 文档
        String filePath = "D:/1.txt" ;
        String reslut = a1.readFile( filePath ) ;
        System.out.println( reslut ); 
    }


    /**
     * 读取指定文件的内容
     * @param filePath ： 文件的路径
     * @return  返回的结果
     */
    public String readFile( String filePath ){
        FileInputStream fis=null;
        String result = "" ;
        try {
            // 根据path路径实例化一个输入流的对象
            fis  = new FileInputStream( filePath );
            InputStreamReader reader = new InputStreamReader(fis,"GBK");
            //2. 返回这个输入流中可以被读的剩下的bytes字节的估计值；
            int size =  fis.available() ;
            //3. 根据输入流中的字节数创建byte数组；
            byte[] array = new byte[size];
            //4.把数据读取到数组中；
            fis.read( array ) ;

            //5.根据获取到的Byte数组新建一个字符串，然后输出；
            result = new String(array,"GB2312");

            /*fis = new FileInputStream(filePath); // filePath为文件路径
            // 声明一个字节数组
            byte[] b = new byte[1024];
            StringBuffer str = new StringBuffer();
            int len ;
            // 循环读取
            while ((len = fis.read(b)) != -1) {
                str.append(new String(b, 0, len,"GB2312"));
            }

            System.out.println(str.toString());*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if ( fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result ;
    }


}
