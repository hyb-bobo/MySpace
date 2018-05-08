package Java多线程核心技术01;

/**
 * Created by zhangyanana    on 2017/3/4.
 */
/*
生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，
如果店中有产品了再通知消费者来取走产品
    分析: 1.是否设计多线程？是，生产者，消费者
         2.是否涉及到共享数据？有！考虑线程的安全
         3.此共享数据是谁？即为产品的数量
         4.是否设计线程的通信？存在生产者与消费者的通信

 */

public class TestProduceConsume {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Produtor p1 = new Produtor(clerk);
        Consumer c1 = new Consumer(clerk);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        t1.setName("生产者1");
        t2.setName("消费者1");
        t1.start();
        t2.start();

    }
}

class Clerk {
    //商品容量
    int capacity = 20;
    //当前商品数量
    int product = 0;

    public synchronized void addProduct() {//生产产品
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println(Thread.currentThread().getName() + ":生产了" + product + "个产品");
            notifyAll();
        }
    }

    public synchronized void consumeProduct() {//消费产品
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":消费了" + product + "个产品");
            product--;
            notifyAll();
        }
    }


}

class Produtor implements Runnable {
    Clerk clerk;

    public Produtor(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("生产者生产产品");
        while (true) {
            try {//sleep一下，让效果更明显
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }

}

class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("消费者消费产品");
        while (true) {
            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }

}