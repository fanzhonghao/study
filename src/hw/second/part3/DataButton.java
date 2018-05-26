package hw.second.part3;

import javax.swing.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-23
 * Description:
 * <p>
 * -----------------------
 */
public class DataButton extends JButton {
    private int num;
    public DataButton(int num){
        this.num = num;
        if (num != 0) this.setText(String.valueOf(num));
        else this.setText("");
    }

    public void setNum(int num) {
        this.num = num;
        if (num != 0) this.setText(String.valueOf(num));
        else this.setText("");
    }

    public int getNum() {
        return num;
    }
}
