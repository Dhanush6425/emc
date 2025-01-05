package emc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {

    public void createTable(Connection con, String table_name){
        Statement st=null;
        try{
            String sql="CREATE TABLE "+table_name+"(name varchar(200),pickup_point int,drop_point int,booking_time TIME)";
            st= con.createStatement();
            st.executeUpdate(sql);
            if(st!=null)
            {
                System.out.println("Table Created");
            }else {
                System.out.println("Table Creation Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertData(Connection con,String table_name,String name,String pickup,String drop,String time)
    {
        Statement st;
        //ResultSet rs=null;
        try{
            System.out.println("Values will be insert into DataBase");
            String sql=String.format("INSERT INTO %s(name,pickup_point,drop_point,booking_time) VALUES('%s','%s','%s','%s');",table_name,name,pickup,drop,time);
            st= con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Row Inserted");
            }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void showTables(Connection con) {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';")) {
            System.out.println("Tables in the database:");
            while (rs.next()) {
                System.out.println(rs.getString("table_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error showing tables: " + e.getMessage());
        }
    }

    public void deleteTable(Connection con, String tbname) {
        Statement st;
        try {
            String sql = String.format("DROP TABLE IF EXISTS %s;", tbname);
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Table deleted successfully (if it existed).");
        } catch (SQLException e) {
            System.out.println("Error while deleting table: " + e.getMessage());
        }
    }

}

