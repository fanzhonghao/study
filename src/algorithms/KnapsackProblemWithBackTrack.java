package algorithms;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-19
 * Description:
 * <p>
 * -----------------------
 */
public class KnapsackProblemWithBackTrack {
    public static void main(String[] args) {
        KnapsackProblemWithBackTrack knapsackobject = new KnapsackProblemWithBackTrack();
        LinkedList<item> hasItems = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入物品数量");
        int num = in.nextInt();
        item[] items = new item[num];
        System.out.println("请输入物品信息 value weight");
        for (int i = 0;i < num;i++){
            int value = in.nextInt();
            int weight = in.nextInt();
            items[i] = knapsackobject.new item(value,weight);
        }
        System.out.println("请输入最大重量");
        int mostWeight = in.nextInt();
        System.out.println("maxValue " + knapsackobject.trackBackFun(hasItems,items,mostWeight));
    }

    private int trackBackFun(LinkedList<item> hasItems,item[] items,int mostWeight){
        int mostValue = 0;
        int maxValue = 0;
        int i = 0;
        for (;i < items.length;i++){
            if (!hasItems.contains(items[i]) && items[i].weight <= mostWeight){
                hasItems.add(items[i]);
                mostWeight -= items[i].weight;
                mostValue += items[i].value;

                int returnValue = trackBackFun(hasItems,items,mostWeight);
                mostValue += returnValue;
                if (maxValue < mostValue){
                    maxValue = mostValue;
                }

                mostWeight += items[i].weight;
                mostValue -= returnValue;
                mostValue -= items[i].value;
                hasItems.remove(items[i]);
            }
        }
        return maxValue;
    }
    class item{
        double value;
        double weight;
        double valuePerWeight;
        item(double value,double weight){
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = value / weight;
        }
    }
}
/*
20 10 30 20 65 30 60 50 40 40
*/