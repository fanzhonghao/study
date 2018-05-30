package exerice;

import exerice.newPIM.PIMCollection;
import exerice.newPIM.PIMEntity;

import java.util.Iterator;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-28
 * Description:
 * <p>
 * -----------------------
 */
public class PIMCollectionTest {
    public static void main(String[] args) {
        PIMCollection pimCollection = new PIMCollection();
        pimCollection.getAll();
        Iterator<PIMEntity> iterator = pimCollection.iterator();
        System.out.println("All");
        printIterator(iterator);
        pimCollection.getTodos();
        iterator = pimCollection.iterator();
        System.out.println("Todo");
        printIterator(iterator);
        pimCollection.getAppointments();
        iterator = pimCollection.iterator();
        System.out.println("Appointment");
        printIterator(iterator);
        pimCollection.getContacts();
        iterator = pimCollection.iterator();
        System.out.println("Contact");
        printIterator(iterator);
        pimCollection.getNotes();
        iterator = pimCollection.iterator();
        System.out.println("Note");
        printIterator(iterator);
        pimCollection.getItemsForDate("04/28/2018");
        iterator = pimCollection.iterator();
        System.out.println("04/28/2018");
        printIterator(iterator);
        pimCollection.getAllByOwner("fan");
        iterator = pimCollection.iterator();
        System.out.println("Fan");
        printIterator(iterator);
    }
    static void printIterator(Iterator<PIMEntity> iterator){
        while (iterator.hasNext()){
            PIMEntity pimEntity = iterator.next();
            System.out.println(pimEntity.toString());
        }
    }
}
