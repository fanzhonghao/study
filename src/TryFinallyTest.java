/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-20
 * Description:
 * <p>
 * -----------------------
 */
public class TryFinallyTest {
    public static void main(String[] args) {
        TryAndFinally t = new TryAndFinally();
        System.out.println("return: i = " + t.out());
    }
}
class TryAndFinally{
    int i;
    public TryAndFinally(){
        i = 10;
    }
    int out(){
        try {
            System.out.println("test1");
            try {
                Thread.sleep(1000);
                Thread.interrupted();
                System.out.println("hello");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        }finally {
            System.out.println("test");
            i = 5;
            System.out.println("i = " + i);
//            return i;
        }
    }
}