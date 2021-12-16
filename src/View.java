import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JLabel label1= new JLabel("Introduceți primul polinom: ",SwingConstants.CENTER);
    private JLabel label2= new JLabel("Introduceți al doilea polinom: ",SwingConstants.CENTER);
    private JLabel label3= new JLabel("Rezultatul operației selectate este: ",SwingConstants.CENTER);
    private JLabel label5= new JLabel("Restul împărțirii este: ",SwingConstants.CENTER);
    private JTextField textField1= new JTextField();
    private JTextField textField2= new JTextField();
    private JTextField textField3= new JTextField();
    private JTextField textField4= new JTextField();
    private JLabel label4= new JLabel("Alegeți Operația",SwingConstants.CENTER);
    private JRadioButton button1= new JRadioButton("Adunare");
    private JRadioButton button2= new JRadioButton("Scădere");
    private JRadioButton button3= new JRadioButton("Inmulțire");
    private JRadioButton button4= new JRadioButton("Derivare");
    private JRadioButton button5= new JRadioButton("Integrare");
    private JRadioButton button6= new JRadioButton("Impărțire");
    private JRadioButton button7= new JRadioButton("CE");
    private JLabel emptyLabel= new JLabel("");
    private JLabel emptyLabel2= new JLabel("");
    private JLabel emptyLabel3= new JLabel("");
    private JLabel emptyLabel4= new JLabel("");
    private JLabel emptyLabel6= new JLabel("");
    private JLabel emptyLabel7= new JLabel("");
    private JButton submitButton= new JButton("Submit");
    ButtonGroup group=new ButtonGroup();
    public View() {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700,525));
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(0,2));
        panel1.add(label1);
        label1.setFont(new Font("Serif", Font.PLAIN, 20));
        panel1.add(textField1);

        panel1.add(label2);
        label2.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(textField2);

        panel1.add(label4);
        label4.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(button1);
        button1.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(emptyLabel);
        panel1.add(button2);
        button2.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(emptyLabel2);
        panel1.add(button3);
        button3.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(emptyLabel3);
        panel1.add(button6);
        button6.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(emptyLabel6);
        panel1.add(button4);
        button4.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(emptyLabel4);
        panel1.add(button5);
        button5.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(emptyLabel7);
        panel1.add(button7);
        button7.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(label3);
        label3.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(textField3);
        panel1.add(label5);
        label5.setFont(new Font("Serif",Font.PLAIN,20));
        panel1.add(textField4);
        panel.add(panel1);
        JPanel panel2= new JPanel();
        panel2.add(submitButton);
        submitButton.setFont(new Font("Serif",Font.PLAIN,20));
        panel.add(panel2);

        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
        group.add(button5);
        group.add(button6);
        group.add(button7);

        Controller buttonListener=new Controller(this);
        submitButton.addActionListener(buttonListener);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JRadioButton getButton1() {
        return button1;
    }

    public JRadioButton getButton2() {
        return button2;
    }

    public JRadioButton getButton3() {
        return button3;
    }

    public JRadioButton getButton4() {
        return button4;
    }

    public JRadioButton getButton5() {
        return button5;
    }

    public JRadioButton getButton6() {
        return button6;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JRadioButton getButton7() {
        return button7;
    }
}
