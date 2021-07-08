package Test;

import javax.swing.*;
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
public class PanelChangeTest extends JFrame implements ActionListener{
    JButton jButton,jButton1;
    CardLayout cardLayout;
    Panel panel = new Panel();

    public PanelChangeTest(){
        setTitle("Hello First");
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        setBounds(500,280,400,200);

        jButton = new JButton("first");

        jButton1 = new JButton("second");
        panel.add(jButton);
        panel.add(jButton1);
        add(panel);

        jButton.addActionListener(this);
        jButton1.addActionListener(this);


        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PanelChangeTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            cardLayout.next(panel);
        }else cardLayout.previous(panel);
    }
}
