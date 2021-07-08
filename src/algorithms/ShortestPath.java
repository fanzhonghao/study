package algorithms;

import java.util.LinkedList;
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
public class ShortestPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入节点个数");
        int num1 = in.nextInt();
        System.out.println("输入线的条数");
        int num = in.nextInt();
        LinkedList<node> a = new LinkedList<>();
        for (int i = 0;i < num;i++){
            int dot1 = in.nextInt();
            int dot2 = in.nextInt();
            int len = in.nextInt();
            node n = new node(dot1,dot2,len);
            a.addFirst(n);
            node n1 = new node(dot2,dot1,len);
            a.addFirst(n1);
        }
        System.out.println("输入源点和终点");
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println("点" + b + "到点" + c + "的最短距离为： " + shortCal(a,b,c,num1));
    }
    static int shortCal(LinkedList<node> a,int b,int c,int num){//从b到c的最短路径
        int[] has = new int[a.size()];
        node[] note = new node[a.size()];//记录
        int len = -1;
        LinkedList<node> link = new LinkedList<>();
        has[0] = b;
        node n0 = new node(b,b,0);
        note[0] = n0;
        for (int i = 0;i < num;i++){
            for (int j = 0;j < a.size();j++){//把刚加入的点的所有出边的点加入
                if (a.get(j).dot1 == has[i]){
                    link.addFirst(a.remove(j));
                    linkSort(link);
                }
            }

            for (int j = 0;j < a.size();j++){
                if (a.get(j).dot2 == has[i]) {
                    a.remove(j);
                    j--;
                }
            }

            //
            for (int j = 0;j < link.size();j++)
                if (link.get(j).dot2 == has[i])
                {
                    link.remove(j);
                    j--;
                }
            //
            node min = null;
            if (link.size() > 0){
                min = link.removeFirst();//现在距离最短的
            }else return -1;

//            System.out.println("min: " + min.dot2);



            if (min != null){
                has[i+1] = min.dot2;
                System.out.println(min.dot2);
            }else return -1;

            int k = 0;
            for (;k <= i;k++){

                if (note[k].dot2 == min.dot1){
                    min.dot1 = b;
                    min.len = note[k].len + min.len;
                    note[i+1] = min;
//                    System.out.println("k: " + k);
                    break;
                }
            }

            if (min.dot2 == c){
                len = min.len;
                break;
            }
        }
        return len;
    }
    static void linkSort(LinkedList<node> link){
        node n = link.removeFirst();
        int i = 0;
        for (;i < link.size();i++){
            if (n.len < link.get(i).len) break;
        }
        link.add(i,n);
    }

}
class node{
    int dot1,dot2;
    int len;
    public node(int dot1,int dot2,int len){
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.len = len;
    }
}