package Java多线程核心技术;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Author: hyb
 * Date: Created in 2018/5/4 9:59
 */
public class WriteData {
    public void writeMethod(PipedOutputStream outputStream){
        try {
            System.out.println("write:");
            for(int i=0;i<300;i++){
                String outData = ""+(i+1);
                outputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ReadData{
    public void readMethod(PipedInputStream inputStream){
        try {
            System.out.println("read:");
            byte[] bytes = new byte[20];
            int length = inputStream.read(bytes);
            while (length !=-1){
                String newData = new String(bytes, 0, length);
                System.out.print(newData);
                length = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


class ThreadWrite extends Thread{
    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;
    public ThreadWrite(WriteData writeData,PipedOutputStream pipedOutputStream){
        this.writeData = writeData;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(pipedOutputStream);
    }
}


class ThreadRead extends Thread{
    private ReadData readData;
    private PipedInputStream pipedInputStream;
    public ThreadRead(ReadData readData,PipedInputStream pipedInputStream){
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        readData.readMethod(pipedInputStream);
    }
}


class RunPipe{
    public static void main(String[] args){
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();

            pipedInputStream.connect(pipedOutputStream);
//            pipedOutputStream.connect(pipedInputStream);


            ThreadRead threadRead = new ThreadRead(readData, pipedInputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData,pipedOutputStream);
            threadWrite.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
