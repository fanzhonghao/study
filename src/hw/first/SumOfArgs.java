package hw.first;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-25
 * Description:ll
 * <p>统计命令行参数中数字之
 * 和。
 * -----------------------
 */
public class SumOfArgs {
    public static void main(String[] args) {
        long sum = 0;
        int num;
        for (int i = 0;i < args.length;i++){
            try {
                num = Integer.parseInt(args[i]);
            } catch (NumberFormatException e){
                continue;
            }
            sum += num;
        }
        System.out.println(sum);
    }
}
