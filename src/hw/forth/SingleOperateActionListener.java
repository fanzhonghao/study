package hw.forth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-23
 * Description:
 * <p>
 * -----------------------
 */
public class SingleOperateActionListener implements ActionListener {//单操作符监听
    StringBuffer s;
    JTextField jTextField;

    SingleOperateActionListener(JTextField jTextField,StringBuffer s){
        this.s = s;
        this.jTextField = jTextField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        OperateButton b = (OperateButton) e.getSource();
        if (s.length() == 0) return;
        try {
            double d = Double.parseDouble(String.valueOf(s));
            String operate = b.getOperate();
            switch (operate){
                case "clear":
                    System.out.println("clear");
                    s.delete(0,s.length());break;
                case "back":
                    System.out.println("begin: " + s);
                    s.deleteCharAt(s.length()-1);
                    System.out.println("end: " + s);
                    break;
                case "1/x": d = 1.0 / d; s.delete(0,s.length());s.append(d);break;
                case "sin": d = Math.sin(d); s.delete(0,s.length());s.append(d);break;
                case "sqrt": d = Math.sqrt(d); s.delete(0,s.length());s.append(d);break;
                case "+/-": d = 0 - d; s.delete(0,s.length());s.append(d);break;
            }
        }catch (Exception e1){//字符串中有操作符
            if (b.getOperate().equals("back")){
                s.deleteCharAt(s.length()-1);
            }else s.delete(0,s.length());
        }
        jTextField.setText(String.valueOf(s));
    }
}