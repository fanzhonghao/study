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
public class EqualSignActionListener implements ActionListener{
    JTextField jTextField;
    StringBuffer s;
    public EqualSignActionListener(JTextField jTextField,StringBuffer s){
        this.jTextField = jTextField;
        this.s = s;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            double result = new StringCal(String.valueOf(s)).cal();
            s.delete(0,s.length());
            s.append(result);
            jTextField.setText(String.valueOf(s));
        }catch (Exception e1){
            jTextField.setText("error");
        }
    }
}
