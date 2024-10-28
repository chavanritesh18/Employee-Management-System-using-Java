import java.awt.*;
import  javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class Home extends JFrame implements ActionListener {

    JButton Add,View,Update,Remove;
    Home()
    {
        setLayout(null);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("Home1.png"));
        Image img2= img1.getImage().getScaledInstance(1200,750,Image.SCALE_DEFAULT);
        ImageIcon img3= new ImageIcon(img2);
        JLabel img=new JLabel(img3);
        img.setBounds(0,0,1200,750);
        add(img);
        JLabel l1=new JLabel("Employee Management System ");
        l1.setBounds(600,50,600,50);
        l1.setFont(new Font("RALEWAY",Font.BOLD,35));
        l1.setForeground(Color.WHITE);
        img.add(l1);

        Add=new JButton("Add");
        Add.setBounds(600,130,200,50);
        Add.addActionListener(this);
        img.add(Add);

        View=new JButton("View");
        View.setBounds(900,130,200,50);
        View.addActionListener(this);
        img.add(View);

        Update=new JButton("Update");
        Update.setBounds(600,250,200,50);
        Update.addActionListener(this);
        img.add(Update);

        Remove=new JButton("Remove");
        Remove.setBounds(900,250,200,50);
        Remove.addActionListener(this);
        img.add(Remove);



        setVisible(true);
        setSize(1200,700);
        setLocation(100, 60);
//        setSize(1200,750);
//        setVisible(true);
//        setLocation(200,50);

    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==Add)
        {
            setVisible(false);
            new Add();
        }
        else if (e.getSource()==View)
        {
            setVisible(false);
            new View();
        }
        else if (e.getSource()==Update)
        {
            setVisible(false);
            new View();
        }
        else if(e.getSource()==Remove)
        {
            new Remove();
            setVisible(false);
        }

    }

    public static void main(String args[])
    {
        new Home();
    }
}
