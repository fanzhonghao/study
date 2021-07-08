package exerice.newPIM;

import exerice.dbOperate.DBoperate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ----------------------
 * PIMCollection集合实现{
 * @code RemotePIMCollection}
 * 和 {@code Collection}接
 * 口的所有方法。
 *
 *
 * @author :fan
 * @Date :18-5-26
 * -----------------------
 */
public class PIMCollection implements RemotePIMCollection, Collection {
    private LinkedList<PIMEntity> linkedList;
    private  DBoperate dBoperate;
    private ResultSet resultSet = null;
    public PIMCollection(){
        dBoperate = new DBoperate();
        dBoperate.connect();
        linkedList = new LinkedList<>();
    }
    @Override
    public PIMCollection getNotes() {
        linkedList.clear();
        resultSet = dBoperate.query("note");
        getPIMCollection(resultSet);
        return this;
    }

    @Override
    public PIMCollection getNotes(String owner) {
        linkedList.clear();
        resultSet = dBoperate.query("note");
        getPIMCollection(resultSet,owner);
        return this;
    }

    @Override
    public PIMCollection getTodos() {
        linkedList.clear();
        resultSet = dBoperate.query("todo");
        getPIMCollection(resultSet);
        return this;
    }

    @Override
    public PIMCollection getTodos(String owner) {
        linkedList.clear();
        resultSet = dBoperate.query("todo");
        getPIMCollection(resultSet,owner);
        return this;
    }

    @Override
    public PIMCollection getAppointments() {
        linkedList.clear();
        resultSet = dBoperate.query("appointment");
        getPIMCollection(resultSet);
        return this;
    }

    @Override
    public PIMCollection getAppointments(String owner) {
        linkedList.clear();
        resultSet = dBoperate.query("appointment");
        getPIMCollection(resultSet,owner);
        return this;
    }

    @Override
    public PIMCollection getContacts() {
        linkedList.clear();
        resultSet = dBoperate.query("contact");
        getPIMCollection(resultSet);
        return this;
    }

    @Override
    public PIMCollection getContacts(String owner) {
        linkedList.clear();
        resultSet = dBoperate.query("contact");
        getPIMCollection(resultSet,owner);
        return this;
    }

    @Override
    public PIMCollection getItemsForDate(String d) {
        LinkedList<PIMEntity> list = new LinkedList();
        list.addAll(getTodos().linkedList);
        list.addAll(list.size(),getAppointments().linkedList);
        linkedList.clear();
        Iterator<PIMEntity> iterator = list.iterator();
        while (iterator.hasNext()){
            PIMEntity p = iterator.next();
            String[] a = p.toString().split("##");
            for(String s : a){
                if (s.matches("^date.*")){
                    if (s.substring(5).equals(d))
                        linkedList.add(p);
                }
            }
        }
        return this;
    }

    @Override
    public PIMCollection getItemsForDate(String d, String owner) {
        LinkedList<PIMEntity> list = new LinkedList<>();
        list.addAll(getTodos(owner).linkedList);
        list.addAll(getAppointments(owner).linkedList);
        linkedList.clear();
        Iterator<PIMEntity> iterator = list.iterator();
        while (iterator.hasNext()){
            PIMEntity p = iterator.next();
            String[] a = p.toString().split("##");
            for(String s : a){
                if (s.matches("^date.*")){
                    if (s.substring(5).equals(d))
                        linkedList.add(p);
                }
            }
        }
        return this;
    }

    @Override
    public PIMCollection getAll() {
        linkedList.clear();
        resultSet = dBoperate.query();
        try {
            while (resultSet.next()){
                String type = resultSet.getString(1);
                String data = resultSet.getString(2);


                String[] datas = data.split("##");
//                if (datas[1].substring(14).equals("true")){
//                    System.out.println(datas[1]);
//                    PIMEntity pimEntity = getPIMItem(type,data);
//                    linkedList.addLast(pimEntity);
//                }

                PIMEntity pimEntity = getPIMItem(type,data);
                linkedList.addLast(pimEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public PIMCollection getAllByOwner(String owner) {
        LinkedList<PIMEntity> list = new LinkedList<>();
        list.addAll(getTodos(owner).linkedList);
        list.addAll(getAppointments(owner).linkedList);
        list.addAll(getContacts(owner).linkedList);
        list.addAll(getNotes(owner).linkedList);


//        LinkedList list1 = new LinkedList();
//        list1.addAll(getAll().linkedList);
//        for (int i = 0;i < list1.size();i++){
//            if (list1.get(i).toString().split("##")[0].substring(6).equals(owner)){
//                list1.remove(i);
//                i--;
//            }
//        }

        linkedList.clear();
        linkedList.addAll(list);

//        linkedList.addAll(list1);
        return this;
    }

    @Override
    public boolean add(PIMEntity pimEntity) {
        return linkedList.add(pimEntity);
    }

    public boolean addAll(PIMCollection collections){
        return linkedList.addAll(collections);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return linkedList.contains(o);
    }

    @Override
    public Iterator iterator() {
        return linkedList.iterator();
    }

    @Override
    public Object[] toArray() {
        return linkedList.toArray();
    }

    @Override
    public boolean add(Object o) {
        linkedList.addLast((PIMEntity) o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return linkedList.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return linkedList.addAll(c);
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return linkedList.equals(o);
    }

    @Override
    public int hashCode() {
        return linkedList.hashCode();
    }

    @Override
    public boolean retainAll(Collection c) {
        return linkedList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return linkedList.toArray(a);
    }

    public PIMEntity getPIMItem(String type,String data){
        PIMEntity pimEntity = null;
        switch (type){
            case "todo":
                pimEntity = new PIMTodo();
                break;
            case "contact":
                pimEntity = new PIMContact();
                break;
            case "note":
                pimEntity = new PIMNote();
                break;
            case "appointment":
                pimEntity = new PIMAppointment();
                break;
        }
        pimEntity.fromString(data);
        return pimEntity;
    }

    public void getPIMCollection(ResultSet resultSet) {
        try {
            while (resultSet.next())
            {
                String type = resultSet.getString(1);
                String data = resultSet.getString(2);
                PIMEntity pimEntity = getPIMItem(type,data);
                linkedList.addLast(pimEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getPIMCollection(ResultSet resultSet,String owner){
        try {
            while (resultSet.next()){
                String type = resultSet.getString(1);
                String data = resultSet.getString(2);
                PIMEntity pimEntity = getPIMItem(type,data);
                String[] array = pimEntity.toString().split("##");
                if (array[0].substring(6).equals(owner)) linkedList.addLast(pimEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
