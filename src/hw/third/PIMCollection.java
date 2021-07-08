package hw.third;

//import hw.second.part1.*;

import hw.second.part1.PIMEntity;

import java.lang.reflect.Array;
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
    private LinkedList<PIMEntity> list = new LinkedList<>();
    private int size;
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
        PIMEntity[] result = new PIMEntity[size];
        for (int i = 0;i < size;i++){
            result[i] = list.get(i);
        }
        return result;
    }

    @Override
    public boolean add(Object o) {
        boolean flag = true;
        try {
            PIMEntity p = (PIMEntity) o;
            list.add(p);
            size++;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean remove(Object o) {
        boolean flag = true;
        try {
            PIMEntity p = (PIMEntity) o;
            list.remove(p);
            size--;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean flag = true;
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            try {
                PIMEntity p = (PIMEntity) iterator.next();
                list.add(p);
                size++;
            }catch (Exception e){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        list.clear();
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {//取交集
        boolean flag = false;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
                PIMEntity p = (PIMEntity) iterator.next();
                if (!c.contains(p)) {
                    list.remove(p);
                    size--;
                    flag = true;
                }
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = true;
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            try {
                PIMEntity p = (PIMEntity) iterator.next();
                if (list.contains(p)) list.remove(p);
            }catch (Exception e){
                flag = false;
            }
        }
        size = 0;
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            try {
                PIMEntity p = (PIMEntity) iterator.next();
                if (!list.contains(p)) return false;
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        PIMEntity[] p;
        Class cs = a.getClass();
        p = (PIMEntity[]) Array.newInstance(cs,size);
        for (int i = 0;i < size;i++)
            p[i] = list.get(i);
        return p;
    }

    public Collection getTodos(){
        PIMCollection pimCollection = new PIMCollection();
        for(PIMEntity p : list){
            String[] a = p.toString().split("##");
            if (a[0].equals("Type todo")) pimCollection.add(p);
        }

        return pimCollection;
    }

    public Collection getAppointments(){
        PIMCollection pimCollection = new PIMCollection();
        for(PIMEntity p : list){
            String[] a = p.toString().split("##");
            if (a[0].equals("Type appointment")) pimCollection.add(p);
        }

        return pimCollection;
    }

    public Collection getContact(){
        PIMCollection pimCollection = new PIMCollection();
        for(PIMEntity p : list){
            String[] a = p.toString().split("##");
            if (a[0].equals("Type contact")) pimCollection.add(p);
        }

        return pimCollection;
    }

    public Collection getNotes(){
        PIMCollection pimCollection = new PIMCollection();

        for(PIMEntity p : list){
            String[] a = p.toString().split("##");
            if (a[0].equals("Type note")) {
                pimCollection.add(p);
            }

        }

        return pimCollection;
    }

    public Collection getItemsForDate(Date d){
        PIMCollection pimCollection = new PIMCollection();
        for(PIMEntity p : list){
            String[] a = p.toString().split("##");
            if (a[0].equals("Type todo") || a[0].equals("Type appointment")){
                String[] dates = d.toString().split(" ");
                String[] dates1 = a[2].split(" ");
                if (dates[1].equals(dates1[1]) && dates[2].equals(dates1[2]) && dates[5].equals(dates1[5]))
                {
                    pimCollection.add(p);
                }
            }
        }
        return pimCollection;
    }

}
