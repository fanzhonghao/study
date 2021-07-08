package hw.third;

import hw.second.part1.*;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-22
 * Description:
 * <p>
 * -----------------------
 */
public class PIMCollectionTest {
    public static void main(String[] args) {
        PIMCollection pimCollection = new PIMCollection();
        PIMNote pimNote = new PIMNote();
        pimNote.fromString("priority:normal" + "##data:pimNote data first");
        pimCollection.add(pimNote);

        PIMAppointment pimAppointment = new PIMAppointment();
        pimAppointment.fromString("priority:normal" + "##date:04/28/2018" + "##description:appointment data first");
        pimCollection.add(pimAppointment);

        PIMTodo pimTodo = new PIMTodo();
        pimTodo.fromString("priority:normal" + "##date:04/28/2018" + "##data:todo data first");
        pimCollection.add(pimTodo);

        PIMContact pimContact = new PIMContact();
        pimContact.fromString("priority:normal" + "##firstName:fan" + "##lastName:yang" + "##emailAddress:1412328318@qq.com");
        pimCollection.add(pimContact);

        LinkedList<PIMEntity> linkedList = new LinkedList<>();
        PIMNote pimNote1 = new PIMNote();
        pimNote1.fromString("priority:normal" + "##data:pimNote data second");
        linkedList.add(pimNote1);
        PIMAppointment pimAppointment1 = new PIMAppointment();
        pimAppointment1.fromString("priority:normal" + "##date:04/29/2018" + "##description:appointment data second");
        linkedList.add(pimAppointment1);
        PIMTodo pimTodo1 = new PIMTodo();
        pimTodo1.fromString("priority:normal" + "##date:04/29/2018" + "##data:todo data second");
        linkedList.add(pimTodo1);
        PIMContact pimContact1 = new PIMContact();
        pimContact1.fromString("priority:normal" + "##firstName:fan" + "##lastName:li" + "##emailAddress:1412328318@qq.com");
        linkedList.add(pimContact1);
        pimCollection.addAll(linkedList);

        System.out.println("All:");
        Iterator iterator = pimCollection.iterator();
        printCollection(iterator);

        System.out.println("Notes:");
        Iterator iterator1 = pimCollection.getNotes().iterator();
        printCollection(iterator1);

        System.out.println("Todos:");
        Iterator iterator2 = pimCollection.getTodos().iterator();
        printCollection(iterator2);

        System.out.println("Contacts:");
        Iterator iterator3 = pimCollection.getContact().iterator();
        printCollection(iterator3);

        System.out.println("Appointments:");
        Iterator iterator4 = pimCollection.getAppointments().iterator();
        printCollection(iterator4);

        Date date = new Date(2018-1900,4-1,28);
        System.out.println("GetByDate:");
        Iterator iterator5 = pimCollection.getItemsForDate(date).iterator();
        printCollection(iterator5);

        PIMEntity[] pimEntities = (PIMEntity[]) pimCollection.toArray();
        int num = 0;
        for (PIMEntity pimEntity : pimEntities){
            System.out.println("Arrays" + (++num) + ": " + pimEntity.toString());
        }

        pimCollection.clear();
        System.out.println("After Clear");
        System.out.println("Collection size: " + pimCollection.size());
    }
    private static void printCollection(Iterator iterator){
        while (iterator.hasNext()){
            PIMEntity p = (PIMEntity) iterator.next();
            System.out.println(p.toString());
        }
    }
}
