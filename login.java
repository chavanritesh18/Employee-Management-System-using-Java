import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JTextField user1;
    JPasswordField pass1;
    login()
    {
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        
        JLabel user=new JLabel("User Name : ");
        user.setFont(new Font("serif",Font.BOLD,20));
        user.setBounds(40,65,200,50);
        user.setForeground(Color.WHITE);
        add(user);

        JLabel pass=new JLabel("Password   : ");
        pass.setFont(new Font("serif",Font.BOLD,20));
        pass.setBounds(40,110,200,50);
        pass.setForeground(Color.white);
        add(pass);

        user1=new JTextField();
        user1.setBounds(150,80,200,30);
        add(user1);

        pass1=new JPasswordField();
        pass1.setBounds(150,125,200,30);
        add(pass1);

        JButton login=new JButton("Log In");
        login.setBounds(150,180,200,30);
        login.addActionListener(this);
        add(login);

        // ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("admin2.jpg"));
        // Image img2=img1.getImage().getScaledInstance(300,175,Image.SCALE_DEFAULT);
        // ImageIcon img3=new ImageIcon(img2);
        // JLabel imgadmin= new JLabel(img3);
        // imgadmin.setBounds(360,50, 250, 190);
        // add(imgadmin);

        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("background1.jpg"));
        Image im2=im1.getImage().getScaledInstance(720,400,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel imgbg= new JLabel(im3);
        imgbg.setBounds(0,0, 720, 400);
        add(imgbg);


        setVisible(true);
        setSize(600, 350);
        setLocation(500, 200);
    }

    public void actionPerformed(ActionEvent e)
    {
        String username=user1.getText();
        String password=pass1.getText();
        try {
            Conection c = new Conection();
            String query = "select * from admn where username='" + username + "' and password='" + password + "'";
            ResultSet reslt = c.stmt.executeQuery(query);
            if (reslt.next()) {
                this.setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username Or Password !!");
//                setVisible(false);

            }
        }
        catch (Exception er){
            System.out.println(er);
        }

    }
    public static void main(String[] args) {
         new login();
    }
    
}
