import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import com.toedter.calendar.JDateChooser;

public class Add extends JFrame  implements ActionListener {
    static int Id=100;
    static boolean flag=true;

    JButton add_details,back;
    JTextField name1,fname1,phone1,salary1,aadhar1,designation1,address1,email1;
    JComboBox quali1 ;
    JLabel id;
    JDateChooser dob1;
    Add()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading =new JLabel("Add Employee Details");
        heading.setBounds(450,70,350,35);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name =new JLabel("Name :");
        name.setBounds(150,200,200,25 );
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        name1 =new JTextField();
        name1.setBounds(300,200,200,25);
        add(name1);

        JLabel fname =new JLabel("Last Name :");
        fname.setBounds(600,200,200,25 );
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        fname1 =new JTextField();
        fname1.setBounds(800,200,200,25);
        add(fname1);

        JLabel dob =new JLabel("Date Of Birth :");
        dob.setBounds(150,250,200,25 );
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        dob1 =new JDateChooser();
        dob1.setBounds(300,250,200,25);
        add(dob1);

        JLabel salary =new JLabel("Salary :");
        salary.setBounds(600,250,200,25 );
        salary.setFont(new Font("serif",Font.BOLD,20));
        add(salary);

        salary1 =new JTextField();
        salary1.setBounds(800,250,200,25);
        add(salary1);

        JLabel address =new JLabel("Address :");
        address.setBounds(150,300,200,25 );
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        address1 =new JTextField();
        address1.setBounds(300,300,200,25);
        add(address1);

        JLabel phone =new JLabel("Phone :");
        phone.setBounds(600,300,200,25 );
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        phone1 =new JTextField();
        phone1.setBounds(800,300,200,25);
        add(phone1);

        JLabel email =new JLabel("Email :");
        email.setBounds(150,350,200,25 );
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        email1 =new JTextField();
        email1.setBounds(300,350,200,25);
        add(email1);

        JLabel qualification =new JLabel("Highest Qualification :");
        qualification.setBounds(600,350,200,25 );
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        String [] course={"Diploma","Btech","Mtech","B.sc","B.com","P.hd"};
        quali1 =new JComboBox(course);
        quali1.setBounds(800,350,200,25);
        add(quali1);

        JLabel designation =new JLabel("Designation :");
        designation.setBounds(150,400,200,25 );
        designation.setFont(new Font("serif",Font.BOLD,20));
        add(designation);

        designation1 =new JTextField();
        designation1.setBounds(300,400,200,25);
        add(designation1);

        JLabel aadhar =new JLabel("Aadhar No :");
        aadhar.setBounds(600,400,200,25 );
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);

        aadhar1 =new JTextField();
        aadhar1.setBounds(800,400,200,25);
        add(aadhar1);

        JLabel empid =new JLabel("Employee Id :");
        empid.setBounds(150,450,200,25 );
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);

        if(flag==true) {
            try {
                Conection c = new Conection();
                ResultSet rs = c.stmt.executeQuery("select count(*) from info");
                if (rs.next()) {
                    Id = 1+Id + rs.getInt(1);
                    flag=false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        id =new JLabel(""+Id);
        id.setBounds(300,450,200,25 );
        id.setFont(new Font("serif",Font.BOLD,20));
        add(id);

        add_details=new JButton("Add Details");
        add_details.setBounds(400,530,150,30);
        add_details.addActionListener(this);
        add(add_details);

        back=new JButton("Back");
        back.setBounds(650,530,150,30);
        back.addActionListener(this);
        add(back);


        setVisible(true);
        setSize(1200,700);
        setLocation(100, 60);
//        setSize(1200,700);
//        setVisible(true);
//        setLocation(200,50);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add_details)
        {
                String dbname=name1.getText();
                String dbfname=fname1.getText();
                String dbphone=phone1.getText();
                String dbsalary=salary1.getText();
                String dbdesignation=designation1.getText();
                String dbaadhar=aadhar1.getText();
                String dbid =""+Id;
                String dbemail=email1.getText();
                String dbdob= ((JTextField) dob1.getDateEditor().getUiComponent()).getText();
                String dbeducation= (String)quali1.getSelectedItem();
                String dbadress=address1.getText();
//
            try {
                Conection c=new Conection();
                String query = "insert into info values('"+dbid+"','"+dbname+"','"+dbfname+"','"+dbaadhar+"','"+dbdob+"','"+dbsalary+"','"+dbadress+"','"+dbphone+"','"+dbemail+"','"+dbeducation+"','"+dbdesignation+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully !!");
                    Id=Id+1;
                setVisible(false);
                new Home();
            }
            catch (Exception ea)
            {
                System.out.println("Complet All filds And enter correct values !!");
                JOptionPane.showMessageDialog(null,"Complet All filds And enter correct values !!");
            }
        }
        else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String [] args)
    {
        new Add();
    }
}
