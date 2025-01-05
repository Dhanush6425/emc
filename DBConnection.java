package emc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class DBConnection {

    private String host;
    private int portno;
    private String dbname;

    public DBConnection(String host,int portno,String dbname){
        this.host=host;
        this.portno=portno;
        this.dbname=dbname;
    }

    public Connection db_connection(String dbname,String user,String password)
    {
        Connection con=null;
        try{

            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://"+host+":"+portno+"/"+dbname, user, password);
            if (con != null && !con.isClosed()) {
                System.out.println("Connection is open.");
            } else {
                System.out.println("Connection is closed or null.");
            }
        }
        catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL Driver not found. Ensure it's included in the project dependencies.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to establish connection. Check database credentials and URL.");
            e.printStackTrace();
            System.exit(0);
        }
        return con;
    }
    public void closedb(Connection con)
    {
        Scanner sc=new Scanner(System.in);
        String yn;
        System.out.print("Do you want to close the connection(y/n): ");
        yn = sc.nextLine();
        if(Objects.equals(yn, "y")){
            try {
                con.close();
                System.out.println("Connection Closed");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
