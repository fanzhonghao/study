package hw.second.part1;

import com.sun.org.apache.bcel.internal.util.ByteSequence;

import java.io.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class filedemo {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            String s = "fan.dat";
            FileOutputStream f1 = new FileOutputStream(s);
            ObjectOutputStream f2 = new ObjectOutputStream(f1);


            f2.writeObject(new tDeom());

            f2.flush();

            FileInputStream f = new FileInputStream(s);
            ObjectInputStream f3 = new ObjectInputStream(f);
            tDeom t = (tDeom) f3.readObject();
            System.out.println("3 " + t.getA());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class tDeom implements Serializable{
    String a;
    public tDeom(){
        a = "hello fan";
    }
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
