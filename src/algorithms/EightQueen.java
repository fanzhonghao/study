package algorithms;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-19
 * Description:
 * <p>
 * -----------------------
 */
public class EightQueen {
    static int[] site = new int[8];
    public static void main(String[] args) {
        siteQueen(0);
    }
    private static void siteQueen(int row){
        if (row == 8){
            System.out.println("第 " + (++Count.count) + " 个");
            for (int i = 0;i < 8;i++)
            {
                for (int j = 0;j < 8;j++){
                    if (site[i] != j) System.out.print(" 0 ");
                    else System.out.print(" 1 ");
                }
                System.out.println();
            }

        }else {
            for (int i = 0;i < 8;i++){
                if (placeQueen(row,i)){
                    site[row] = i;
                    siteQueen(row+1);
                }
            }
        }
    }
    private static boolean placeQueen(int row,int s){
        boolean flag = true;
        for (int i = 0;i < row;i++)
            if (Math.abs(i - row) == Math.abs(s - site[i]) || site[i] == s) return false;
        return flag;
    }
}
class Count{
    static int count = 0;
}
