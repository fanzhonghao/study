package hw.second;
import java.awt.Dimension;

        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JPanel;
        import javax.swing.JScrollPane;

public class test extends JFrame {


    public test() {
        super("TestJScrollPane");
        this.setLayout(null);
        this.setBounds(200, 200, 200, 300);
        JLabel label = new JLabel("深入浅出Java Swing 程序设计");
        JPanel panel = new JPanel();
        panel.add(label);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(100, 100, 100, 300);
        panel.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, scrollPane.getHeight()*2));
        this.add(scrollPane);
//        panel.revalidate(); //告诉其他部件,我的宽高变了
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new test();
    }
}