package easyCustomerAndProducer;

import java.util.LinkedList;

/* *
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-6
 * Description:
 * <p>
 * -----------------------
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Begin...");
        LinkedList list = new LinkedList();
        Producer p = new Producer(list);
        Customer c = new Customer(list);
        p.start();
        c.start();
    }
}
