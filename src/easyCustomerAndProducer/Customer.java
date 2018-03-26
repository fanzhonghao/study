package easyCustomerAndProducer;

import java.util.LinkedList;

/* *
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-6
 * Description:
 * 消费者
 * -----------------------
 */
public class Customer extends Thread{
    LinkedList list;
    public Customer(LinkedList list){
        this.list = list;
    }
    private int consume(){
        while (list.isEmpty()){
            System.out.println("仓库为空...");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (int)list.pop();
    }

    @Override
    public void run() {
        while (true){
            System.out.println("消费： " + consume());
        }
    }
}
