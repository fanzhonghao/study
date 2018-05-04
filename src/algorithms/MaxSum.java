package algorithms;

import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-26
 * Description:
 * <p>
 * -----------------------
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] a = new int[num];
        for (int i = 0;i < num;i++){
            a[i] = in.nextInt();
        }
        System.out.println("MaxSum: " + sumCal(a));
    }
    static int sumCal(int[] a){
        int len = a.length;
        int sum = 0;
        int max = -1;
        for (int i = 0;i < len;i++){
            sum += a[i];
            if (sum < 0) sum = 0;
            else if (sum > max) max = sum;
        }
        return max;
    }
}
