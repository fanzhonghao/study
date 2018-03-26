import java.util.Random;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-7
 * Description:
 * 一个线程资源共享冲突Demo
 * -----------------------
 */
public class TestConstructorFunction2 {
    static test t = new test();
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true){
                    t.set(1,10);
                    if (t.getNo1()*10 != t.getNo2())
                        System.out.println("t.no1 = " + t.getNo1() + " t.no2 = " + t.getNo2());

                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    t.set(2,20);
                    if (t.getNo1() * 10 != t.getNo2())
                        System.out.println("t.no1 = " + t.getNo1() + " t.no2 = " + t.getNo2());
                }
            }
        }.start();
    }
}
class test{
    private int no1;
    private int no2;

    public void set(int no1,int no2){
        this.no1 = no1;
        try {
            Thread.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.no2 = no2;
    }

    public int getNo1() {
        return no1;
    }

    public int getNo2() {
        return no2;
    }
}