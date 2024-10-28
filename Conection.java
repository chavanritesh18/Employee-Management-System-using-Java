import java.sql.*;

public class Conection {
    Statement stmt;
    Connection con;
    Conection(){
        try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        con=DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee","root","Root@123");  
        //here sonoo is database name, root is username and password  
        stmt=con.createStatement();
//        con.close()
        }
        catch(Exception e){ System.out.println(e);}  
}
    public static void main(String[] args) {
        new Conection();
    }
    
}
