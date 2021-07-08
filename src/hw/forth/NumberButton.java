package hw.forth;


import javax.swing.*;
import java.awt.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-22
 * Description:
 * <p>
 * -----------------------
 */
public class NumberButton extends JButton {
    private int num;
    public NumberButton(int num){
        this.num = num;
        this.setText("" + num);
        this.setForeground(Color.BLACK);
    }
    public int getNum(){
        return num;
    }
}
