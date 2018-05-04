package algorithms;

import java.util.LinkedList;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-18
 * Description:
 * <p>优先级队列
 * 优先级的比较简化为单纯的数
 * 字比较，数字越大，优先级越
 * 高。
 * -----------------------
 */
public class PriorityQueueDemo {
    LinkedList list;
    public PriorityQueueDemo(){
        list = new LinkedList();
    }
    /*
    add:添加数据
    a:优先级
     */
    public void add(int a){//
        int i = 0;
        int size = list.size();
        boolean flag = false;
        for (;i < size;i++){
            if ((int)list.get(i) < a){
                list.add(i,a);
                flag = true;
                break;
            }
        }
        if (!flag)list.addLast(a);
    }
    /*
    得到队列最前面一个
     */
    public int get(){
        return (int) list.removeFirst();
    }
}
