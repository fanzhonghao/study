package exerice.calPanel.functionalPage.actionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-26
 * Description:
 * <p>
 * -----------------------
 */
public class LonInActionListener implements ActionListener{
    private String username;
    private CardLayout cardLayout;
    private Panel fatherPanel;
    public LonInActionListener(String username,final CardLayout cardLayout,final Panel fatherPanel){
        this.username = username;
        this.cardLayout = cardLayout;
        this.fatherPanel = fatherPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
