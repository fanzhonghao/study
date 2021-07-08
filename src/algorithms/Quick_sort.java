package algorithms;

import java.util.Random;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-9
 * Description:
 * <p>
 * -----------------------
 */
public class Quick_sort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[10];
        for (int i = 0;i < 10;i++)
            a[i] = r.nextInt(100);
        System.out.println("排序前");
        for (int i : a){
            System.out.print(i + "\t");
        }
        System.out.println("\n排序后");
        new Quick_sort().sort(a,0,9);
        for (int i : a){
            System.out.print(i + "\t");
        }
    }
    /*
    插入排序核心
    a:数组
    min:待排数组最小下标
    max:待排数组最大下标
     */
    public void sort(int[] a,int min,int max){
        if (min >= max) return;
        int i = min - 1,
        j = min;
        for (;j < max;j++){
            if (a[j] < a[max]){
                i++;
                exchange(a,i,j);
            }
        }
        i++;
        exchange(a,i,j);
        if (i > min && i < max){
            sort(a,min,i-1);
            sort(a,i+1,max);
        }else if (i == min){
            sort(a,i+1,max);
        }else if (i == max){
            sort(a,min,max-1);
        }
    }
    /*
    交换数字
     */
    private void exchange(int[] a,int min,int max){
        int temp = a[min];
        a[min] = a[max];
        a[max] = temp;
    }
}
