package algorithms;

import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-7
 * Description:
 * <p>Knapsack Problem：
 * 已知物品的价值及重量的情况
 * 下，如何在只拿固定重量的物
 * 品的情况下获得最大的价值。
 * -----------------------
 */
public class KnapsackProblem {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入物品个数");
        int num = in.nextInt();
        double value,weight;
        item[] items = new item[num];
        System.out.println("请输入物品的重量及价值，输入格式为：价值 重量");
        for (int i = 0;i < num;i++){
            value = in.nextDouble();
            weight = in.nextDouble();
            items[i] = new item(value,weight);
        }


        System.out.println("请输入最大重量");
        double mostWeight = in.nextDouble();
        System.out.println("可以拿部分的情况");
        new KnapsackProblem().fractionalChoose(items,mostWeight);
        System.out.println("\n只能拿整体的情况");
        new KnapsackProblem().oneOrNot(items,mostWeight);

    }

    /**
     * fractionChoose：可将物品切分来拿的情况下能够拿的最大价值，及拿的方法
     * @param items 物品详细信息
     * @param mostWeight 可拿最大重量
     */
    void fractionalChoose(item[] items,double mostWeight){
        if (items.length == 0) return;
        int nowHaveWeight = 0;//记录目前拿取的总重量
        for (int i = 0;i < items.length;i++)
            nowHaveWeight += items[i].weight;
        sortByValuePerWeight(items);
        int i = 0;
        boolean flag = false;
        double temp = 0;
        for (;i < items.length;i++){
            if (nowHaveWeight <= mostWeight) break;
            if (nowHaveWeight - mostWeight > items[i].weight) {
                nowHaveWeight -= items[i].weight;
                continue;
            }
            flag = true;
            temp = items[i].weight;
            items[i].weight = items[i].weight - nowHaveWeight + mostWeight;
            break;
        }
        System.out.println("拿的物品:\n价值  重量");
        double totalValue = items[i].weight * items[i].valuePerWeight;
        System.out.println(items[i].value + " " + items[i].weight);

        for (int j = i+1;j < items.length;j++){
            System.out.println(items[j].value + " " + items[j].weight);
            totalValue += items[j].value;
        }
        System.out.println("总价值：  "  + totalValue);
        if (flag)
            items[i].weight = temp;
    }

    /**
     * oneOrNot：物品不可切分情况下，能够拿的最大价值及拿的方法
     * 此方法使用贪心算法，贪心策略为如果可以的话每次选取当前性价比最高的
     * @param items 物品详细信息
     * @param mostWeight 可拿最大重量
     */
    void oneOrNot(item[] items,double mostWeight){
        int nowWeight = 0;
        int flag = items.length-1;
        double totalValue = 0;
        for (;flag >= 0 ;flag--){
            if (nowWeight + items[flag].weight > mostWeight) continue;
            nowWeight += items[flag].weight;
            totalValue += items[flag].value;
            System.out.println(items[flag].value + " " + items[flag].weight);
        }
        System.out.println("总价值： " + totalValue);
    }

    /**
     * sortByValuePerWeight：将物品数组按照单位价值正序排序
     * @param items 物品详细信息数组
     */
    void sortByValuePerWeight(item[] items){
        for (int i = 1;i < items.length;i++){//插入排序
            if (items[i].valuePerWeight < items[i-1].valuePerWeight){
                int j = i;
                for (;j >= 1;j--)
                {
                    if (items[j].valuePerWeight >= items[j-1].valuePerWeight) break;
                    item temp = items[j];
                    items[j] = items[j-1];
                    items[j-1] = temp;
                }
                if (items[1].valuePerWeight < items[0].valuePerWeight){
                    item temp = items[1];
                    items[1] = items[0];
                    items[0] = items[1];
                }
            }
        }
    }
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