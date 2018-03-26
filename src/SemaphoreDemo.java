import java.util.Random;
import java.util.concurrent.Semaphore;

/* *----------------------------
 * @Date: 18-3-6
 * Description:
 *   This code is used to study
 * the use of semaphore in
 * multithreading program.
 * -----------------------------
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //设置3个资源
        BoundResource resource = new BoundResource(3);
        //设置10个线程
        for (int i = 0;i < 10;i++){
            new UserThread(resource).start();
        }
    }
}

/* *
 * 输出当前线程名和参数
 */
class Log{
    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + "： " + s);
    }
}
/* *
 *  临界区
 */
class BoundResource{
    private final Semaphore semaphore;
    private final int no;
    private final static Random r = new Random(3000000);
    public BoundResource(int no){
        //no为资源个数
        this.no = no;
        this.semaphore = new Semaphore(no);
    }
    /*
        使用资源
     */
    public void use() throws InterruptedException{
        semaphore.acquire();
        try {
            doUse();
        }finally {
            semaphore.release();
        }
    }
    /*
        实际使用资源
     */
    public void doUse() throws InterruptedException {
        Log.println("Begin: used = " + (no - semaphore.availablePermits()));
        Thread.sleep(r.nextInt(500));
        Log.println("End: used = " + (no - semaphore.availablePermits()));
    }
}
/* *
 * 使用资源的线程
 */

class UserThread extends Thread{
    private final static Random r = new Random(30000);
    private final BoundResource resource;
    public UserThread(BoundResource resource){
        this.resource = resource;
    }
    public void run(){
        try {
            while (true){
                resource.use();
                Thread.sleep(r.nextInt(3000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}