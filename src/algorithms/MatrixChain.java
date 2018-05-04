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
public class MatrixChain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] a = new int[num];//保存矩阵
        for (int i = 0;i < num;i++)
            a[i] = in.nextInt();
        int[][] l = new int[num][num];//记录括号位置

        int n = a.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n+1];
        matrixChain(a,m,s);
        print(1,n,s);
        System.out.println();
    }
    static void matrixChain(int[] p,int[][] m,int[][] s){
        int n = p.length - 1;
        for (int l = 2;l <= n;l++){
            for (int i = 1;i <= n-l+1;i++){
                int j = i + l - 1;
                m[i-1][j-1] = Integer.MAX_VALUE;
                for (int k = i;k <= j-1;k++){
                    int q = m[i-1][k-1] + m[k][j-1] + p[i-1]*p[k]*p[j];
                    if (q < m[i-1][j-1]){
                        m[i-1][j-1] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    static void print(int i,int j,int[][] s){
        if (i == j)
            System.out.print("A");
        else {
            System.out.print("(");
            print(i,s[i][j],s);
            print(s[i][j]+1,j,s);
            System.out.print(")");
        }
    }
}
