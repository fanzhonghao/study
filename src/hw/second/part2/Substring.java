package hw.second.part2;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-1
 * Description:
 * <p>
 * -----------------------
 */
public class Substring {
    public static void main(String[] args) {
        if (args.length < 2){
            System.out.println("参数格式为 string num num");
            return;
        }
        if (args.length > 3){
            System.out.println("参数格式为 string num num");
            return;
        }
        String orignString = args[0];
        StringBuffer goalString = new StringBuffer();
//        String s1 = null;
        int begin;
        int end = 0;
        try {
            begin = Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            System.out.println("第二个参数应为整数");
            return;
        }
        if (args.length == 3){
            try {
                end = Integer.parseInt(args[2]);
            }catch (NumberFormatException e){
                System.out.println("第三个参数应为整数");
                return;
            }
        }
        if (args.length == 2){
            for (int i = begin;i < orignString.length();i++){
                goalString.append(orignString.charAt(i));
            }
        }else {
            if (begin+end > orignString.length()){
                System.out.println("越界");
                return;
            }
//            s1 = orignString.substring(begin,begin+end);
            for (int i = 0;i < end;i++){
                goalString.append(orignString.charAt(begin++));
            }
        }

        System.out.println(goalString);
//        System.out.println(s1);
    }
}
