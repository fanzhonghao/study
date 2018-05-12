package algorithms;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-10
 * Description:
 * <p>使用BellmanFord算法
 * 计算单源点最短路径
 * -----------------------
 */
public class BellmanFord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入点的个数");
        int dotNum = in.nextInt();
        System.out.println("请输入边的条数");
        int edgeNum = in.nextInt();
        System.out.println("请输入源点");
        int source = in.nextInt();
        System.out.println("请输入边，格式 name1(int) name2(int) dis(int)");
        Dis[] dis = new Dis[edgeNum];
        for (int i = 0;i < edgeNum;i++)
        {
            int name1 = in.nextInt();
            int name2 = in.nextInt();
            int dis1 = in.nextInt();
            dis[i] = new Dis(name1,name2,dis1);
        }

        int[][] dis1 = new int[dotNum][dotNum];
        for (int i = 0;i < dotNum;i++)
            for (int j = 0;j < dotNum;j++)
                dis1[i][j] = Integer.MAX_VALUE;
        for (Dis dis2 : dis){
            dis1[dis2.name1][dis2.name2] = dis2.dis;
        }
        System.out.println("原距离数组");
        for (int i = 0;i < dotNum;i++)
        {
            System.out.println();
            for (int j = 0;j < dotNum;j++){
                if (dis1[i][j] == Integer.MAX_VALUE) System.out.printf("  Max");
                else System.out.printf("%5d",dis1[i][j]);
            }
        }
        System.out.println();

        if (new BellmanFord().BellmanFordCal(dis,source,dotNum)){
            System.out.println("有负值环");
        }

    }

    /**
     * BellmanFordCal algorithms
     * @param source 源点
     * @return 返回是否存在权重为负的环
     */
    private boolean BellmanFordCal(Dis[] dis,int source,int dotNum){
        int[] nodeDis = new int[dotNum];
        for (int i = 0;i < nodeDis.length;i++)
            nodeDis[i] = Integer.MAX_VALUE;
        nodeDis[source] = 0;
        boolean flag = false;
        for (int i = 0;i < dis.length;i++){
            for (Dis dis1 : dis){
                if (nodeDis[dis1.name1] != Integer.MAX_VALUE &&
                        nodeDis[dis1.name1] + dis1.dis < nodeDis[dis1.name2]){
                    nodeDis[dis1.name2] = nodeDis[dis1.name1] + dis1.dis;
                }
            }
        }
        for (Dis dis1 : dis){
            if (nodeDis[dis1.name2] > nodeDis[dis1.name1] + dis1.dis)
                flag = true;
        }
        System.out.println("节点" + source + "到各点的最短距离：");
        for (int j = 0;j < dotNum;j++)
            System.out.print( j + ": " + nodeDis[j] + "\t");
        System.out.println();

        return flag;
    }
}
class Dis{
    int name1;
    int name2;
    int dis;
    Dis(int name1,int name2,int dis){
        this.name1 = name1;
        this.name2 = name2;
        this.dis = dis;
    }
}
/*
0 1 6 0 3 7
1 2 5 1 4 -4 1 3 8
2 1 -2
3 2 -3 3 4 9
4 0 2 4 2 7
 */