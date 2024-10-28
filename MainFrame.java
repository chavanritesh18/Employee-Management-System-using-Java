import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

/**
 * EmpManagement
 */
public class MainFrame extends JFrame implements ActionListener{
    MainFrame(){

        getContentPane().setBackground(Color.white);
        setLayout(null); 

        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(340, 30, 1200, 60);
        heading.setFont(new Font("serif",Font.PLAIN,50));
        heading.setForeground(Color.BLACK);
        add(heading);

        ImageIcon pic=new ImageIcon(ClassLoader.getSystemResource("Main.jpg"));
        Image i1=pic.getImage().getScaledInstance(1300,550,Image.SCALE_DEFAULT);
        ImageIcon pic2=new ImageIcon(i1);
        JLabel img=new JLabel(pic2);
        img.setBounds(10,100,1165,550);
        add(img);

        JButton button = new JButton("Click To Continue");
        button.setBounds(550,470,150,30);
        button.setBackground(Color.gray);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        img.add(button);


        setVisible(true);
        setSize(1200,700);
        setLocation(100, 60);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new login();
    }
    public static void main(String[] args) {
        new MainFrame();
    }
    
}
