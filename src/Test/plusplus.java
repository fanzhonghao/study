package Test;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-27
 * Description:
 * <p>Java使用中间缓存变量的
 * 机制，j = j++;可以看做
 * temp = j;
 * j = j+1;
 * j = temp;
 * -----------------------
 */
public class plusplus {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0;i < 100;i++){
            j = j++;
        }
        System.out.println(j);
    }
}
