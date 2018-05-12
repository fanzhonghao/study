package algorithms;

import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-10
 * Description:
 * <p>使用Floyd算法
 * -----------------------
 */
public class AllPairsShortestPathes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入点的个数");
        int ponitNum = in.nextInt();
        int[][] dis = new int[ponitNum][ponitNum];
        for (int i = 0;i < ponitNum;i++)
        {
            for (int j = 0;j < ponitNum;j++)
                dis[i][j] = Integer.MAX_VALUE;
        }
        System.out.println("请输入边的条数");
        int edgeNum = in.nextInt();
        System.out.println("请输入边的信息，格式为：点序列 点序列 距离");
        for (int i = 0;i < edgeNum;i++){
            int first = in.nextInt();
            int second = in.nextInt();
            dis[first][second] = in.nextInt();
        }
        System.out.println("原始数据");
        for (int i = 0;i < dis.length;i++)
        {
            for (int j = 0;j < dis.length;j++)
                if (dis[i][j] == Integer.MAX_VALUE){
                    System.out.print("         max");
                }else System.out.printf("%12d ",dis[i][j]);
            System.out.println();
        }
        System.out.println("最短路径");
        floydMethod(dis);
    }
    /**
     * 使用Floyd算法计算所有节点对的最短路径
     * @param dis 节点间的距离数组
     */
    private static void floydMethod(int[][] dis){

        int[][][] dis1 = new int[dis.length+1][dis.length+1][dis.length+1];
        dis1[0] = dis;
        for (int k = 1;k <= dis.length;k++){
            for (int i = 0;i < dis.length;i++){
                for (int j = 0;j < dis.length;j++){
                    if (dis1[k-1][i][k-1] == Integer.MAX_VALUE || dis1[k-1][k-1][j] == Integer.MAX_VALUE){
                        dis1[k][i][j] = dis1[k-1][i][j];
                    }else dis1[k][i][j] = dis1[k-1][i][j] < dis1[k-1][i][k-1] + dis1[k-1][k-1][j] ? dis1[k-1][i][j] :
                            dis1[k-1][i][k-1] + dis1[k-1][k-1][j];
                }
            }
        }
        for (int i = 0;i < dis.length;i++){
            for (int j = 0;j < dis.length;j++)
                if (dis1[dis.length][i][j] == Integer.MAX_VALUE) System.out.print("       max");
                else System.out.printf("%10d",dis1[dis.length][i][j]);
            System.out.println();
        }
    }
}
/*
0 0 0 0 1 3 0 2 8 0 4 -4
1 1 0 1 3 1 1 4 7
2 1 4 2 2 0
3 0 2 3 2 -5 3 3 0
4 3 6 4 4 0
 */
