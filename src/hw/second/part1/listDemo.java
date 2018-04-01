package hw.second.part1;

import java.util.LinkedList;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class listDemo {
    LinkedList l = new LinkedList();

    public static void main(String[] args) {
        listDemo l = new listDemo();
        new a(l.l);
        System.out.println(l.l.size());
        System.out.println(l.l.getFirst());
    }
}
class a{
    String b;
    public a(LinkedList list){
        b = "hello";
        list.add(b);
    }
}
