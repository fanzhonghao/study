package hw.second.part1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import hw.third.dbOperate;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class executeCommand {
    private String command;
    public executeCommand(String s){
        setCommand(s);
    }
    public void exe(LinkedList<PIMEntity> linkedList){
        if (command.equalsIgnoreCase("list")) listCommand(linkedList);
        else if (command.equalsIgnoreCase("create")) linkedList.addLast(createCommand());
        else if (command.equalsIgnoreCase("save")) saveCommand(linkedList);
        else if (command.equalsIgnoreCase("load")) linkedList.addAll(loadCommand());
        else if (command.equalsIgnoreCase("quit")) quitCommand();
    }
    private void listCommand(LinkedList<PIMEntity> linkedList){
        //print a list of all PIM items
        int size = linkedList.size();
        if (size == 0){
            System.out.println("There are 0 items");
            return;
        }
        PIMEntity[] p = new PIMEntity[100];
        for (int i = 0;i < size;i++){
            p[i] = linkedList.get(i);
        }
        for (int i = 0;i < size;i++){
            String[] a = p[i].toString().split("##");
            System.out.println("Item " + (i+1) + ": ");
            int no = a.length;
            for (int j = 0;j < no;j++){
                System.out.println("    " + a[j]);
            }
        }

    }
    private PIMEntity createCommand(){
        //add a new item
        PIMEntity p;
        System.out.println("Enter an item type ( todo, note, contact or appointment )");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuffer s1 = new StringBuffer();
        switch (s){
            case "todo": {
                p = new PIMTodo();
                System.out.println("Enter todo priority:");
                s1.append("priority:" + in.nextLine());
                System.out.println("Enter date for todo item:");
                s1.append("##date:" + in.nextLine());
                System.out.println("Enter todo data:");
                s1.append("##data:" + in.nextLine());
                p.fromString(String.valueOf(s1));
                break;
            }
            case "note":{
                p = new PIMNote();
                System.out.println("Enter note priority:");
                s1.append("priority:" + in.nextLine());
                System.out.println("Enter note data:");
                s1.append("##data:" + in.nextLine());
                p.fromString(String.valueOf(s1));
                break;
            }
            case "contact":{
                p = new PIMContact();
                System.out.println("Enter contact priority:");
                s1.append("priority:" + in.nextLine());
                System.out.println("Enter contact first name:");
                s1.append("##firstName:" + in.nextLine());
                System.out.println("Enter contact last name:");
                s1.append("##lastName:" + in.nextLine());
                System.out.println("Enter contact email address:");
                s1.append("##emailAddress:" + in.nextLine());
                p.fromString(String.valueOf(s1));
                break;
            }
            case "appointment":{
                p = new PIMAppointment();
                System.out.println("Enter appointment priority:");
                s1.append("priority:" + in.nextLine());
                System.out.println("Enter appointment date:");
                s1.append("##date:" + in.nextLine());
                System.out.println("Enter appointment description:");
                s1.append("##description:" + in.nextLine());
                p.fromString(String.valueOf(s1));
                break;
            }
            default: {
                p = new PIMTodo();
                System.out.println("Error");
                return null;
            }
        }
        return p;
    }
    private void saveCommand(LinkedList<PIMEntity> linkedList){
        //save data in a file
        linkedList.addAll(0,loadCommand());
        fileOperate f = null;
        try {
            f = new fileOperate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.saveAll(linkedList);

    }
    private LinkedList<PIMEntity> loadCommand(){
        // read a list of items from a file
        try {
            return new fileOperate().loadAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }
    private void quitCommand(){
        //log out
        System.out.println("log out");
        System.exit(1);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
