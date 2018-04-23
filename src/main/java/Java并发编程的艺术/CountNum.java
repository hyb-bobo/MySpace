package Java并发编程的艺术;

/**
 * Author: hyb
 * Date: Created in 2018/4/23 15:38
 */
public class CountNum {


    final int getCount = 0;

    private static void getNum(final int[] arr){
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (CountNum.class){
                    int count = 0;
                    for (int i = 0;i<arr.length;i++){
                        count = arr[i]+ count;
                    }

                }
            }

        });

    }

    public static void main(String[] args){
//        int[] arr ={1,2,3};
//        getNum(arr);
        long count =0L;
        long startTime = System.currentTimeMillis();
        for (long i=0;i<1000000L;i++){
            count += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(count);
        System.out.println();
        System.out.println(endTime - startTime);
    }


}
