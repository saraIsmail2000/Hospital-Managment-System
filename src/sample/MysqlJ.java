package sample;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



///////////////////////////////
//   Classe sqlConnection:   //
///////////////////////////////



public class MysqlJ{

    /*public static void main(String[] args) throws SQLException

    {

        //Connection conn=null;
        //instruction = null;
        ResultSet resultat = null;

        //Class.forName("com.mysql.jdbc.Driver" );
        String url="jdbc:mysql://localhost:3306/mydb";
        String user="";

        String pass="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");


        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("SQL Connection to database established!");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            return;
        }
        Statement instruction;

        instruction = conn.createStatement();


        Scanner s= new Scanner(System.in);
        String choice="Q", Query="Q";

        do{

            System.out.println(" Do you want to Query(Q), Insert (I) or Exit (other)");

            choice=s.nextLine();

            if(choice.equals("Q"))
            {
                System.out.println("enter the query");
                Query = s.nextLine();

                resultat = instruction.executeQuery(Query);
                ResultSetMetaData rsmd = resultat.getMetaData();
                int NumOfCol=rsmd.getColumnCount();

                while (resultat.next()) {


                    for (int i=1;i<=NumOfCol;i++)

                        System.out.print(rsmd.getColumnName(i)+":"+resultat.getString(rsmd.getColumnName(i))+"  ");
                    System.out.println();
                }
            }
            if(choice.equals("I"))
            {
                System.out.println("enter the row");
                Query = s.nextLine();

                instruction.executeUpdate(Query);
            }
        } while(choice.equals("Q") || choice.equals("I") );



    }

     */
}
