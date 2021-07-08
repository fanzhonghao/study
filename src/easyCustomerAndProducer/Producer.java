package easyCustomerAndProducer;

import java.util.LinkedList;
import java.util.Random;

/* *
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-6
 * Description:
 * 生产者
 * -----------------------
 */
public class Producer extends Thread{
    LinkedList list;
    public Producer(LinkedList list){
        this.list = list;
    }
    private void produce(){
        while (list.size() >= 100){
            System.out.println("仓库已满...");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int a = new Random().nextInt(100);
        System.out.println("生产: " + a);
        list.addLast(a);
    }

    @Override
    public void run() {
        while (true){
            produce();
        }
    }
}
