package emc;

import java.sql.Connection;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter Credentials to Connect DataBase");
        //Initializing host,Database and portno
        String host, dbname,tbname="";
        int portno;
        Connection con=null;
        Scanner sc = new Scanner(System.in);
        try {
            //Getting input for the server name,portno,DBname
            System.out.print("Enter server: ");
            host = sc.nextLine();
           // System.out.println();
            System.out.print("Enter portNo: ");
            portno = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter DBName: ");
            dbname = sc.nextLine();
           // System.out.println();

            //Intializing and getting input for username and password
            String user, password;
            System.out.printf("Enter %s DB username: ", dbname);
            user = sc.nextLine();
            System.out.printf("Enter %s DB paswword: ", dbname);
            password = sc.nextLine();
            //System.out.println();

            DBConnection db = new DBConnection(host, portno, dbname);
            con = db.db_connection(dbname,user, password);
            Table t=new Table();
            Inputs in=new Inputs();
            String[][] p= in.input();
            //sc.nextLine();
//            System.out.println("Do you want to create table(y/n): ");
//            String yesn=sc.nextLine();
                System.out.print("Enter table name: ");
                tbname=sc.nextLine();
                t.createTable(con,tbname);
                int b=in.getB();
                for(int i=0;i<b;i++)
                {
                    System.out.println(p[i][0]+" "+p[i][1]+" "+p[i][2]+" "+p[i][3]);
                    t.insertData(con,tbname,p[i][0],p[i][1],p[i][2],p[i][3]);
                }

           // t.showTables(con);
            System.out.print("Do you need to delete Table(y/n): ");
            String p1= sc.nextLine();
            if(Objects.equals(p1,"y")){
                t.deleteTable(con,tbname);
            }
            if(con!=null) {
                db.closedb(con);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}