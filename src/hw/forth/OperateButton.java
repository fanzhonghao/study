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
public class OperateButton extends JButton{
    private String operate;
    public OperateButton(String operate){
        this.operate = operate;
//        this.setFont(new Font("微软雅黑",Font.BOLD,16));
        this.setText("" + operate);
        this.setForeground(Color.BLACK);
    }
    public String getOperate(){
        return operate;
    }
}
