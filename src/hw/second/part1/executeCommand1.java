package hw.second.part1;

import hw.third.PIMCollection;
import hw.third.dbOperate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-6
 * Description:
 * <p>数据库操作
 * -----------------------
 */
public class executeCommand1 {
    private String cmd;
    public executeCommand1(String cmd){
        this.cmd = cmd;
    }
    public void exe(LinkedList<PIMEntity> list){
        if (cmd.equalsIgnoreCase("list")) listCmd(list);
        else if (cmd.equalsIgnoreCase("create")) createCmd(list);
        else if (cmd.equalsIgnoreCase("save")) saveCmd(list);
        else if (cmd.equalsIgnoreCase("quit")) quitCmd();
        else if (cmd.equalsIgnoreCase("load")) loadCmd(list);
        else if (cmd.equalsIgnoreCase("getNotes")) getNotes(list);
        else if (cmd.equalsIgnoreCase("getTodos")) getTodos(list);
        else if (cmd.equalsIgnoreCase("getAppointments")) getAppointments(list);
        else if (cmd.equalsIgnoreCase("getContact")) getContact(list);
        else if (cmd.equalsIgnoreCase("getItemsForDate")) getItemsForDate(list);

    }
    private void listCmd(LinkedList<PIMEntity> linkedList){
        //列出
        int size = linkedList.size();
        if (size == 0){
            System.out.println("There are 0 items");
            return;
        }
        PIMEntity[] p = new PIMEntity[1];
        for (int i = 0;i < size;i++){
            p[0] = linkedList.get(i);
            System.out.println("Item " + (i+1) + ": ");
            String[] a = p[0].toString().split("##");
            int no = a.length;
            for (int j = 0;j < no;j++){
                System.out.println("    " + a[j]);
            }
        }
    }
    private void createCmd(LinkedList<PIMEntity> linkedList){
        //创建
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
                System.out.println("Enter date for todo item: (MM/dd/yyyy)");
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
                System.out.println("Enter appointment date: (MM/dd/yyyy)");
                s1.append("##date:" + in.nextLine());
                System.out.println("Enter appointment description:");
                s1.append("##description:" + in.nextLine());
                p.fromString(String.valueOf(s1));
                break;
            }
            default: {
                p = new PIMTodo();
                System.out.println("Error");
                return;
            }
        }
        linkedList.add(p);
    }
    private void saveCmd(LinkedList<PIMEntity> linkedList){
        //保存
        PIMEntity p = null;
        int size = linkedList.size();
        dbOperate db = new dbOperate();
        db.connect();
        for (int i = 0;i < size;i++){
            p = linkedList.get(i);
            String[] a = p.toString().split("##");
            String type = a[0];
            int len = a[0].length();
            String data = p.toString().substring(len+2);
//            System.out.println(type + " " + data);
            db.insert(type,data);
        }
        db.close();
        linkedList.clear();
    }
    private void quitCmd(){
        //退出
        System.out.println("Log out");
        System.exit(1);
    }
    private void loadCmd(LinkedList<PIMEntity> linkedList){
        //加载
        dbOperate db = new dbOperate();
        db.connect();
        ResultSet r = db.query();
        try {
            while (r.next()){
                String type = r.getString(1);
                String data = r.getString(2);
                type = type.substring(5);
                String s = type + "##" + data;
                PIMEntity p = null;
                switch (type){
                    case "appointment": {
                        p = new PIMAppointment();
                        break;
                    }
                    case "contact":{
                        p = new PIMContact();
                        break;
                    }
                    case "note":{
                        p = new PIMNote();
                        break;
                    }
                    case "todo":{
                        p = new PIMTodo();
                        break;
                    }
                }
                if (p != null){
                    p.fromString(s);
                    linkedList.addLast(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getNotes(LinkedList<PIMEntity> linkedList){
        PIMCollection p = new PIMCollection();
        p.addAll(linkedList);

//        System.out.println(p.size());
//        System.out.println("one: " + linkedList.size());

        linkedList.clear();

        linkedList.addAll(p.getNotes());

//        System.out.println(p.getNotes().size());
//        System.out.println("tow: " + linkedList.size());

    }
    private void getTodos(LinkedList<PIMEntity> linkedList){
        PIMCollection p = new PIMCollection();
        p.addAll(linkedList);
        linkedList.clear();
        linkedList.addAll(p.getTodos());
    }
    private void getAppointments(LinkedList<PIMEntity> linkedList){
        PIMCollection p = new PIMCollection();
        p.addAll(linkedList);
        linkedList.clear();
        linkedList.addAll(p.getAppointments());
    }
    private void getContact(LinkedList<PIMEntity> linkedList){
        PIMCollection p = new PIMCollection();
        p.addAll(linkedList);
        linkedList.clear();
        linkedList.addAll(p.getContact());
    }
    private void getItemsForDate(LinkedList<PIMEntity> linkedList){
        PIMCollection p = new PIMCollection();
        p.addAll(linkedList);
        linkedList.clear();
        Date d;
        System.out.println("请输入时间 year month day");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        String[] s = date.split(" ");
        d = new Date(Integer.parseInt(s[0]) - 1900,Integer.parseInt(s[1]) - 1,Integer.parseInt(s[2]));
//        System.out.println(d);
        linkedList.addAll(p.getItemsForDate(d));
    }
}
