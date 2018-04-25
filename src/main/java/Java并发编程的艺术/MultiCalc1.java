package Java并发编程的艺术;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiCalc1 {
    private long startTime = 0L;
    private long endTime = 0L;

    private int totalResult = 0;

    private Boolean[] isCompleted = null;

    private List<Integer> integerList = new ArrayList<Integer>();

    public MultiCalc1(List<Integer> arr){
        integerList.addAll(arr);
    }

    public static void main(String[] args) {
        List<Integer> integerList1 = new ArrayList<Integer>();
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        integerList1.add(1);
        (new MultiCalc1(integerList1)).startUp();
    }

    private boolean isSuccessed() {
        for (int i = 0; i < isCompleted.length; i++) {
            if (!isCompleted[i])
                return false;
        }
        return true;
    }


    private void startUp() {
        int threadNum;
        int numbers = integerList.size();

        System.out.println("请输入要开启的线程数");
        Scanner input = new Scanner(System.in);
        threadNum = input.nextInt();
        isCompleted = new Boolean[threadNum];
        System.out.println("开始计时....");
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= threadNum; i++) {
            isCompleted[i - 1] = false;
            Thread t = new Thread(new CalcThread(i, numbers, threadNum));
            t.start();
        }
        synchronized (MultiCalc1.this) {
            try {
                MultiCalc1.this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("计算结果为：" + totalResult);
        System.out.println("计时结束，总耗时为：" + (endTime - startTime) + "ms");
    }

    class CalcThread implements Runnable {
        private int start;
        private int end;
        private int result;
        private int threadIndex;

        public CalcThread(int threadIndex, int numbers, int threadNum) {
            int step = numbers / threadNum;
            this.threadIndex = threadIndex;
            start = (threadIndex - 1) * step + 1;
            if (threadIndex == threadNum) { //是否是最后一个线程
                end = numbers;
            } else {
                end = threadIndex * step;
            }
            System.out.println(Thread.currentThread().getName() + "---->" + start + "~" + end);
        }

        public void run() {
            for (int i = start; i <= end; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result += integerList.get(i-1);
            }
            System.out.println("result"+result);
            synchronized (MultiCalc1.this) {
                totalResult += result;
                isCompleted[this.threadIndex - 1] = true;
                if (isSuccessed()) {
                    MultiCalc1.this.notify();
                }
            }
            System.out.println("totalResult"+totalResult);
        }
    }
}