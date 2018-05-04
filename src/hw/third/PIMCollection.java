package hw.third;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

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
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
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
