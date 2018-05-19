package hw.third;

import hw.second.part1.PIMEntity;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-28
 * Description:
 * <p>
 * -----------------------
 */
public class PIMCollection implements Collection{
    LinkedList<PIMEntity> list = new LinkedList<>();
    int size;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0;i < size;i++){
            result[i] = list.get(i);
        }
        return result;
    }

    @Override
    public boolean add(Object o) {
        return list.add((PIMEntity) o);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean retainAll(Collection c) {//待看看是干什么的
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = false;
        Iterator iterator = c.iterator();
        while (iterator.hasNext())
        {
            list.remove(iterator.next());
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            if (!contains(c))
                return false;
        }

        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
//        list.toArray()
        return new Object[0];
    }

    public Collection getTodos(){
        return null;
    }

    public Collection getAppointments(){
        return null;
    }

    public Collection getContact(){
        return null;
    }

    public Collection getNotes(){
        return null;
    }

    public Collection getItemsForDate(Date d){
        return null;
    }

}
