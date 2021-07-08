package exerice.newPIM;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-26
 * Description:
 * <p>
 * -----------------------
 */
public interface RemotePIMCollection {
    PIMCollection getNotes();
    PIMCollection getNotes(String owner);
    PIMCollection getTodos();
    PIMCollection getTodos(String owner);
    PIMCollection getAppointments();
    PIMCollection getAppointments(String owner);
    PIMCollection getContacts();
    PIMCollection getContacts(String owner);
    PIMCollection getItemsForDate(String d);
    PIMCollection getItemsForDate(String d, String owner);
    PIMCollection getAll();
    PIMCollection getAllByOwner(String owner);
    boolean add(PIMEntity pimEntity);
}
