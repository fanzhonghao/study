package Test;

import algorithms.PriorityQueueDemo;

import java.util.Random;
import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-27
 * Description:
 * <p>
 * -----------------------
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueueDemo p = new PriorityQueueDemo();
        int[] a = new int[10];
        Random r = new Random();
        System.out.println("随机序列");
        for (int i = 0;i < 10;i++)
        {   int num = r.nextInt(100);
            p.add(num);
            System.out.print(num + "\t");
        }
        System.out.println("\n依次放入优先级队列后调度顺序");
        for (int i = 0;i < 10;i++)
        {
            System.out.print(p.get() + "\t");
        }
    }
}
