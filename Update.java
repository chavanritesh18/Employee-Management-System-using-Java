import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update extends JFrame implements ActionListener {

    JButton update,back;
    JTextField uname1,ufname1,uphone1,usalary1,uaadhar1,udesignation1,uaddress1,uemail1,udob1,uquali1;
    JLabel id;
    String Emp_id;
    Update(String sid) {
        this.Emp_id=sid;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Upload Employee Details");
        heading.setBounds(450, 70, 350, 35);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(150, 200, 200, 25);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        uname1 = new JTextField();
        uname1.setBounds(300, 200, 200, 25);
        add(uname1);

        JLabel ufname = new JLabel("Last Name :");
        ufname.setBounds(600, 200, 200, 25);
        ufname.setFont(new Font("serif", Font.BOLD, 20));
        add(ufname);

        ufname1 = new JTextField();
        ufname1.setBounds(800, 200, 200, 25);
        add(ufname1);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setBounds(150, 250, 200, 25);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        udob1 = new JTextField();
        udob1.setBounds(300, 250, 200, 25);
        add(udob1);

        JLabel salary = new JLabel("Salary :");
        salary.setBounds(600, 250, 200, 25);
        salary.setFont(new Font("serif", Font.BOLD, 20));
        add(salary);

        usalary1 = new JTextField();
        usalary1.setBounds(800, 250, 200, 25);
        add(usalary1);

        JLabel address = new JLabel("Address :");
        address.setBounds(150, 300, 200, 25);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        uaddress1 = new JTextField();
        uaddress1.setBounds(300, 300, 200, 25);
        add(uaddress1);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(600, 300, 200, 25);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        uphone1 = new JTextField();
        uphone1.setBounds(800, 300, 200, 25);
        add(uphone1);

        JLabel email = new JLabel("Email :");
        email.setBounds(150, 350, 200, 25);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        uemail1 = new JTextField();
        uemail1.setBounds(300, 350, 200, 25);
        add(uemail1);

        JLabel qualification = new JLabel("Highest Qualification :");
        qualification.setBounds(600, 350, 200, 25);
        qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(qualification);

        uquali1 = new JTextField();
        uquali1.setBounds(800, 350, 200, 25);
        add(uquali1);

        JLabel designation = new JLabel("Designation :");
        designation.setBounds(150, 400, 200, 25);
        designation.setFont(new Font("serif", Font.BOLD, 20));
        add(designation);

        udesignation1 = new JTextField();
        udesignation1.setBounds(300, 400, 200, 25);
        add(udesignation1);

        JLabel aadhar = new JLabel("Aadhar No :");
        aadhar.setBounds(600, 400, 200, 25);
        aadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(aadhar);

        uaadhar1 = new JTextField();
        uaadhar1.setBounds(800, 400, 200, 25);
        add(uaadhar1);

        JLabel empid = new JLabel("Employee Id :");
        empid.setBounds(150, 450, 200, 25);
        empid.setFont(new Font("serif", Font.BOLD, 20));
        add(empid);


        id = new JLabel();
        id.setBounds(300, 450, 200, 25);
        id.setFont(new Font("serif", Font.BOLD, 20));
        add(id);

        try
        {
            Conection c=new Conection();
            ResultSet r=c.stmt.executeQuery("select * from info where emp_id='"+Emp_id+"'");
            while (r.next())
            {
                id.setText(r.getString("emp_id"));
                uname1.setText(r.getString("name"));
                ufname1.setText(r.getString("Last_Name"));
                uaadhar1.setText(r.getString("Aadhar_No"));
                udob1.setText(r.getString("DOB"));
                usalary1.setText(r.getString("Salary"));
                uaddress1.setText(r.getString("address"));
                uphone1.setText(r.getString("Phone_No"));
                uemail1.setText(r.getString("Email"));
                uquali1.setText(r.getString("Qualification"));
                udesignation1.setText(r.getString("Designation"));

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        update=new JButton("Update Details");
        update.setBounds(400,530,150,30);
        update.addActionListener(this);
        add(update);

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
        if (e.getSource() == update) {
            String dbname=uname1.getText();
            String dbfname=ufname1.getText();
            String dbphone=uphone1.getText();
            String dbsalary=usalary1.getText();
            String dbdesignation=udesignation1.getText();
            String dbaadhar=uaadhar1.getText();
            String dbemail=uemail1.getText();
            String dbdob= udob1.getText();
            String dbeducation=uquali1.getText();
            String dbadress=uaddress1.getText();
//
            try {
                Conection c=new Conection();
                String query = "update info set name='"+dbname+"',Last_Name='"+dbfname+"',Aadhar_No='"+dbaadhar+"',DOB='"+dbdob+"',Salary='"+dbsalary+"',address='"+dbadress+"',Phone_No='"+dbphone+"',Email='"+dbemail+"',Qualification='"+dbeducation+"',Designation='"+dbdesignation+"' where Emp_id=Emp_id";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully !!");
                setVisible(false);
                new Home();
            }
            catch (Exception ea)
            {
                System.out.println("ea");
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
            new Update("");
        }

}
