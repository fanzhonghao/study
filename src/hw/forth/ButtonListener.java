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
public class ButtonListener implements ActionListener {
    private StringBuffer s;
    private JTextField jTextField;
    ButtonListener(JTextField jTextField,StringBuffer s){
        this.s = s;
        this.jTextField = jTextField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof NumberButton){
            NumberButton b = (NumberButton) e.getSource();
            s.append(b.getNum());
        }else if (e.getSource() instanceof OperateButton){
            OperateButton b = (OperateButton) e.getSource();
            s.append(b.getOperate());
        }
        System.out.println(s);
        jTextField.setText(String.valueOf(s));
    }
}