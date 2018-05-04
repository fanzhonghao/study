package algorithms;

import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-25
 * Description:
 * <p>最长公共子串
 * -----------------------
 */
public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String X = in.nextLine();
        String Y = in.nextLine();
        int m = X.length(),n = Y.length();
        int[][] l = new int[m+1][n+1];//记录长度
        char[][] f = new char[m+1][n+1];//记录方向
        int len = LENGTH(X,Y,l,f);
        int x = m,y = n;
        StringBuffer s = new StringBuffer();
        for (;x != 0 && y != 0;){
            if (X.charAt(x-1) == Y.charAt(y-1)) s.append(X.charAt(x-1));
            if (f[x][y] == '\\'){
                x--;
                y--;
            }else if (f[x][y] == '|'){
                x--;
            }else y--;
        }
        System.out.println("LCS长度：" + String.valueOf(len) + "\nLCS： " + s.reverse());
    }
    static int LENGTH(String X,String Y,int[][] l,char[][] f){
        int m = X.length(),n = Y.length();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (X.charAt(i) == Y.charAt(j)){
                    l[i+1][j+1] = l[i][j] + 1;
                    f[i+1][j+1] = '\\';
                }else if (l[i][j+1] >= l[i+1][j]){
                    l[i+1][j+1] = l[i][j+1];
                    f[i+1][j+1] = '|';
                }else {
                    l[i+1][j+1] = l[i+1][j];
                    f[i+1][j+1] = '-';
                }
            }
        }
        return l[m][n];
    }

}
