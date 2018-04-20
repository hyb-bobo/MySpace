package javaConcurrent;

/**
 * 目的是对count进行加一操作，执行1000次，
 * 不过这里是通过10个线程来实现的，每个线程执行100次
 * 正常情况下，应该输出1000。
 * 不过，如果你运行该程序，你会发现结果却不是这样。（每次运行的结果不一定相同，有时候也可能获取到正确的结果）
 */
public class ShareData {
    public static int count = 0;
 
    public static void main(String[] args) {
        final ShareData data = new ShareData();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        //进入的时候暂停1毫秒，增加并发问题出现的几率
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
                        data.addCount();
                    }
                    System.out.print(count + " ");
                }
            }).start();
 
        }
        try {
            //主程序暂停3秒，以保证上面的程序执行完成
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count=" + count);
    }

    /**
     * 即是数据发生共享的部分(写数据的时候，读可以共享数据)，这个部分需要考发生多线程问题
     * 即是所谓的{原子性}
     * 原子性就是指对数据的操作是一个独立的、不可分割的整体。
     * 换句话说，就是一次操作，是一个连续不可中断的过程，数据不会执行的一半的时候被其他线程所修改。
     */
    public void addCount() {
        count++;
    }

    /**
     * 增加 synchronized 关键字
     */
//    public synchronized void addCount() {
//        count++;
//    }
}