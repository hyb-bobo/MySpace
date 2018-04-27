package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/27 11:10
 */
public class MyOneListService {
    public MyOneList addSerivce(MyOneList list,String data){
        try {
            synchronized (list){
                if(list.getSize()<1){
                    Thread.sleep(2000);//模拟从远程获取数据返回
                    System.out.println(Thread.currentThread().getName());
                    list.add(data);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
