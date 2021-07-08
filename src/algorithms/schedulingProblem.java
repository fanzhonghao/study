package algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-8
 * Description:
 * <p>
 * -----------------------
 */
public class schedulingProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入任务个数");
        int jobNum = in.nextInt();
        int[] times = new int[jobNum];
        System.out.println("请输入各个任务运行时间");
        for (int i = 0;i < jobNum;i++){
            times[i] = in.nextInt();
        }
        System.out.println("平均任务周转时间： " + new schedulingProblem().sRTF(times));

        System.out.println("请输入任务名称及运行时间 格式 name time");
        job[] jobs = new job[jobNum];
        for (int i = 0;i < jobNum;i++){
            String name = in.next();
            int runTime = in.nextInt();
            jobs[i] = new job(name,runTime);
        }
        System.out.println("平均周转时间： " + new schedulingProblem().sRTFWithName(jobs));

    }

    /**
     * 使用最短剩余时间方法调度
     * @param times: 各个任务需要运行时间
     * @return 平均周转时间
     */
    private double sRTF(int[] times){
        Arrays.sort(times);
        int sum = 0;
        int nowSum = 0;
        System.out.println("任务调度顺序(时间)");
        for (int i = 0;i < times.length;i++){
            nowSum += times[i];
            System.out.print(times[i] + "\t");
            sum += nowSum;
        }
        System.out.println();
        return ((double)sum) / times.length;
    }
    private double sRTFWithName(job[] jobs){
        for (int i = 1;i < jobs.length;i++){
            if (jobs[i].runTime < jobs[i-1].runTime){
                for (int j = i;j > 0;j--){
                    if (jobs[i].runTime > jobs[i-1].runTime) break;
                    job temp = jobs[i];
                    jobs[i] = jobs[i-1];
                    jobs[i-1] = temp;
                }
            }
        }
        int sum = 0;
        int nowSum = 0;
        System.out.println("调度顺序(任务名字)");
        for (int i = 0;i < jobs.length;i++){
            System.out.print(jobs[i].name + "\t");
            nowSum += jobs[i].runTime;
            sum += nowSum;
        }
        System.out.println();
        return ((double) sum) / jobs.length;
    }
}
class job{
    String name;
    int runTime;
    job(String name,int runTime){
        this.name = name;
        this.runTime = runTime;
    }
}