package algorithms;

import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-25
 * Description:
 * <p>
 * -----------------------
 */
public class LCSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int[][] c = new int[a.length()+1][b.length()+1];
        String d = LCSTest(a,b,c);
        System.out.println("subString: " + d);
    }
    static String LCSTest(String a,String b,int[][] c){
        int aLen = a.length();
        int bLen = b.length();
        int max = 0;
        int maxX = 0;
        StringBuffer s = new StringBuffer();
        for (int i = 0;i < aLen;i++){
            for (int j = 0;j < bLen;j++){
                if (a.charAt(i) == b.charAt(j)){
                    c[i+1][j+1] = c[i][j] + 1;
                    max = max > c[i+1][j+1] ? max : c[i+1][j+1];
                }else {
                    if (max == c[i][j]){
                        maxX = i - c[i][j];
                    }
                    c[i+1][j+1] = 0;
                }
            }
        }
        int l = 0;
        for (int i = maxX;l < max;i++,l++)
            s.append(a.charAt(i));
        return String.valueOf(s);
    }
}
