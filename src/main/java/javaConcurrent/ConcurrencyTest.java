package javaConcurrent;

public class ConcurrencyTest {
    /**
     * 当count 为count = 1000000000l级别时候的效果
     * concurrency :1ms
     * serial:638ms
     */
    private static final long count = 1000000000l;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                int b = 0;
                for (long i = 0; i < count; i++) {
                    b--;
                }
            }
        });
        threadB.start();
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time );
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
