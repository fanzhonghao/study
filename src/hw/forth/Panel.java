package hw.forth;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
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
public class Panel extends JFrame{
    private NumberButton[] numberButtons;
    private OperateButton[] operateButtons;
    private OperateButton dotButton;
    private Color foregroudColor;
    private Color backgroundColor;
    StringBuffer textSource = new StringBuffer();
    public Panel(){
        this.setTitle("Calculator");
        foregroudColor = Color.BLACK;
        backgroundColor = Color.WHITE;
        numberButtons = new NumberButton[10];

        JTextField jTextField = new JTextField();
        jTextField.setHorizontalAlignment(JTextField.RIGHT);
        jTextField.setForeground(foregroudColor);
        jTextField.setFont(new Font("TimesRoman",Font.BOLD,20));
        jTextField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        jTextField.setEditable(false);
        jTextField.setBackground(backgroundColor);
        JPanel panelDown,panelUp;
        panelUp = new JPanel(new BorderLayout());
        panelUp.add(jTextField,BorderLayout.CENTER);

        for (int i = 0;i < 10;i++)
        {
            numberButtons[i] = new NumberButton(i);
            numberButtons[i].addActionListener(new ButtonListener(jTextField,textSource));
        }
        operateButtons = new OperateButton[11];
        String[] operates = {
                "clear","back","+","-","*","/","1/x","sin","sqrt","+/-","="
        };
        for (int i = 0;i < 11;i++)
        {
            operateButtons[i] = new OperateButton(operates[i]);
        }
        for(int i = 2;i < 6;i++){
            operateButtons[i].addActionListener(new ButtonListener(jTextField,textSource));
        }
        operateButtons[0].addActionListener(new SingleOperateActionListener(jTextField,textSource));
        operateButtons[1].addActionListener(new SingleOperateActionListener(jTextField,textSource));

        operateButtons[6].addActionListener(new SingleOperateActionListener(jTextField,textSource));
        operateButtons[7].addActionListener(new SingleOperateActionListener(jTextField,textSource));
        operateButtons[8].addActionListener(new SingleOperateActionListener(jTextField,textSource));
        operateButtons[9].addActionListener(new SingleOperateActionListener(jTextField,textSource));
        operateButtons[10].addActionListener(new EqualSignActionListener(jTextField,textSource));

        dotButton = new OperateButton(".");
        dotButton.addActionListener(new ButtonListener(jTextField,textSource));
        dotButton.setForeground(foregroudColor);
        //
        panelDown = new JPanel();
        panelDown.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        panelDown.add(north,BorderLayout.NORTH);
        north.setLayout(new GridLayout(1,2,30,30));
        operateButtons[0].setFont(new Font("TimesRoman",Font.BOLD,24));
        operateButtons[1].setFont(new Font("TimesRoman",Font.BOLD,24));
        operateButtons[0].setForeground(Color.BLUE);
        operateButtons[1].setForeground(Color.BLUE);
        north.add(operateButtons[0]);
        north.add(operateButtons[1]);
        //
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,north,left);
        panelDown.add(jSplitPane,BorderLayout.NORTH);
        panelDown.add(left,BorderLayout.WEST);
        left.setLayout(new GridLayout(4,3,10,8));
        left.add(numberButtons[7]);
        left.add(numberButtons[8]);
        left.add(numberButtons[9]);
        left.add(numberButtons[4]);
        left.add(numberButtons[5]);
        left.add(numberButtons[6]);
        left.add(numberButtons[1]);
        left.add(numberButtons[2]);
        left.add(numberButtons[3]);
        left.add(dotButton);
        left.add(numberButtons[0]);
        left.add(operateButtons[6]);
        //
        JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);
        panelDown.add(jSplitPane1,BorderLayout.CENTER);
        panelDown.add(right,BorderLayout.EAST);
        right.setLayout(new GridLayout(4,2,10,8));
        right.add(operateButtons[2]);
        right.add(operateButtons[7]);
        right.add(operateButtons[3]);
        right.add(operateButtons[8]);
        right.add(operateButtons[4]);
        right.add(operateButtons[9]);
        right.add(operateButtons[5]);
        right.add(operateButtons[10]);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelUp,panelDown);
        add(splitPane,BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500,350,450,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Panel();
    }
}
