package hw.second.part1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class PIMManager {
    public static void main(String[] args) {
        System.out.println("Welcome to PIM");
        Scanner in = new Scanner(System.in);
        String command;
        LinkedList<PIMEntity> linkedList = new LinkedList<>();
        while (true){
            System.out.println("---Enter a command (suported commands are List Create Save Load Quit\n" +
                    "   and getNotes getTodos getAppointments getContact getItemsForDate)---");
            command = in.next();
            executeCommand1 e = new executeCommand1(command);
            e.exe(linkedList);
        }
    }
}
