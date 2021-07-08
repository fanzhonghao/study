package hw.forth;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-23
 * Description:
 * <p>通过字符串计算结果
 * -----------------------
 */
public class StringCal {
    private String s;
    public StringCal(String s){
        this.s = s;
    }
    public double cal(){
        if (s.charAt(0) == '-') s = "0" + s;
        String[] numStrings = s.split("[+\\-*/]");
        String[] operateStrings = s.split("[0-9.]{1,}");//首先会有一个空格
        LinkedList<Double> linkedList = new LinkedList<>();
        for (String num : numStrings){
            linkedList.add(Double.parseDouble(num));
        }

        //首先乘除，然后加减
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.addAll(Arrays.asList(operateStrings));
        if (!linkedList1.isEmpty()) linkedList1.removeFirst();//去掉开始空格
        double r;
        for (int i = 0;i < linkedList1.size();i++){
            if (String.valueOf(linkedList1.get(i)).equals("*")){
                r = linkedList.get(i) * linkedList.get(i+1);
                linkedList.remove(i);
                linkedList.remove(i);
                linkedList.add(i,r);
                linkedList1.remove(i);
                i--;
            }else if (String.valueOf(linkedList1.get(i)).equals("/")){
                r = linkedList.get(i) / linkedList.get(i+1);
                linkedList.remove(i);
                linkedList.remove(i);
                linkedList.add(i,r);
                linkedList1.remove(i);
                i--;
            }
        }

        for (int i = 0;i < linkedList1.size();i++){
            if (linkedList1.get(i).equals("+")){
                r = linkedList.get(i) + linkedList.get(i+1);
            }else r = linkedList.get(i) - linkedList.get(i+1);
            linkedList.remove(i+1);
            linkedList.add(i+1,r);
        }
        return linkedList.getLast();
    }
}
