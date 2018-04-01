package Test;

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
        int no = in.nextInt();
        int[] sum = new int[1000];
        for (int i = 0;i < no;i++){
            int m = in.nextInt();
            String a = in.next();
            int temp = 0;
            sum[i] = 0;
            int flag = 0;
            int flag1 = 0;
            for (int j = 0;j < m;j++){
                if (a.charAt(j) == '.'){
                    temp++;
                    if (j >= 2 && a.charAt(j-2) == '.' && flag1 == 1 && flag % 3 == 1) {
                        temp--;flag = 0;
                    }
                    flag++;//.
                    flag1 = 0;
                }else {
                    sum[i] += new Main().cal(temp);
                    temp = 0;
                    flag1++;//x
                }
            }
            sum[i] += new Main().cal(temp);
        }
        for (int i = 0;i < no;i++)
            System.out.println(sum[i]);
    }
    int cal(int n){
        return (n + 2) / 3;
    }
}
