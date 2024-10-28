import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Remove extends JFrame implements ActionListener {
    JTextField r;
    JButton remove,back;
    Remove()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel r1=new JLabel("Enter Employee Id :");
        r1.setBounds(200,100,250,30);
        r1.setFont(new Font("serif",Font.BOLD,20));
        add(r1);

        r= new JTextField();
        r.setBounds(400,100,150,30);
        add(r);

        remove=new JButton("Remove Record");
        remove.setBounds(300,200,150,30);
        remove.addActionListener(this);
        add(remove);

        back=new JButton("Back");
        back.setBounds(500,200,150,30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(1000,400);
        setLocation(300,150);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==remove) {
            try {
                String id=r.getText();
                Conection c = new Conection();
                c.stmt.executeUpdate("delete from info where Emp_id='"+id+"'");
                JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception ea) {
                System.out.println(ea);
            }
        }
        else
        {
            new Home();
            setVisible(false);
        }
    }
    public static void main(String [] args) {
        new Remove();
    }
}
