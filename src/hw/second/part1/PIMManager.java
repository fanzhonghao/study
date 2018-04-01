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
        PIMEntity pimEntity;
        System.out.println("Welcome to PIM");
        Scanner in = new Scanner(System.in);
        String command;
        LinkedList<PIMEntity> linkedList = new LinkedList<>();
        while (true){
            System.out.println("---Enter a command (suported commands are List Create Save Load Quit)---");
            command = in.next();
            executeCommand e = new executeCommand(command);
            e.exe(linkedList);
        }
    }
}
