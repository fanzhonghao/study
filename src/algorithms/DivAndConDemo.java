package algorithms;

import java.util.Random;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-18
 * Description:
 * <p>
 * -----------------------
 */
public class DivAndConDemo {
    public static void main(String[] args) {
        int[] a = new int[21];
        int[] b = new int[21];
        Random r = new Random();
        for (int i = 0;i < 20;i++)
        {
            a[i] = r.nextInt(50);
            b[i] = r.nextInt(50);
        }
        new Quick_sort().sort(a,0,19);//排序
        new Quick_sort().sort(b,0,19);
        int[] c = new int[40];
        a[20] = 100;
        b[20] = 100;
        int t1 = 0,t2 = 0;
        for (int i = 0;i < 40;i++){
            c[i] = a[t1] < b[t2] ? a[t1++] : b[t2++];
            System.out.print(c[i] + "\t");
        }
        int no = 5;
        System.out.println("\n" + c[40-no-1]);
        System.out.println(new DivAndConDemo().find(a,19,b,19,40-no));
    }
    int find(int[] a,int m,int[] b,int n,int k){
        if (m == 0) return b[k-1];
        if (n == 0) return a[k-1];
        if (k == 1) return a[0] < b[0] ? a[0] : b[0];
        if (k == m + n) return a[m-1] > b[n-1] ? a[m-1] : b[n-1];
        int i =(int) ((double)m) / (m + n) * (k - 1);
        int j = k - i - 1;
        if (j >= n){
            j = n - 1;
            i = k - n;
        }
        if (((i == 0) || a[i-1] <= b[j]) && b[j] <= a[i]) return b[j];
        if ((j == 0 || b[j-1] <= a[i]) && a[i] < b[j]) return a[i];
        int[] c = new int[20];
        if (a[i] <= b[j]){
            for (int l = i+1;l < a.length;l++)
                c[l-i-1] = a[l];
            return find(c,m-i-1,b,j,k-i-1);
        }
        else{
            for (int l = j+1;l < b.length;l++)
                c[l-i-1] = b[l];
            return find(a,i,c,n-j-1,k-j-1);
        }

    }

}
