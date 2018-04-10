package FileIO;

import java.io.*;

public class SerialCtl implements Serializable {
        String a;
        transient String b;
        public SerialCtl(String aa, String bb){
                a="Not Transient:"+aa;
                b="Transient:"+bb;
        }
        public String toString(){
                return a+"\n"+b;
        }

        private void writeObject(ObjectOutputStream o)throws IOException {
                o.defaultWriteObject();
                o.writeObject(b);
        }
        private void readObject(ObjectInputStream streamr)throws IOException, ClassNotFoundException{
                streamr.defaultReadObject();
                b=(String)streamr.readObject();
        }

        public static void main(String[] args){
                SerialCtl sc =
                        new SerialCtl("Test1","Test2");
                System.out.println("Before:\n"+sc);
                ByteArrayOutputStream buf =
                        new ByteArrayOutputStream();
                try{
                        ObjectOutputStream out1 = new
                                ObjectOutputStream(buf);

                        out1.writeObject(sc);

                        ObjectInputStream in1 = new
                                ObjectInputStream(new
                                ByteArrayInputStream(buf.toByteArray()));

                        SerialCtl sc2 = (SerialCtl)in1.readObject();
                        System.out.println("After:\n"+sc2);

                }catch(ClassNotFoundException e){
                        e.printStackTrace();
                }catch(IOException e){
                        e.printStackTrace();

                }
        }
}