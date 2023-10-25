package com.vinayak.jdbc;
 
import java.sql.*;

public class databaseManager {
   
   String url;
   Connection conn;
   
  public databaseManager (String connectionURL, String username, String password){
     url = connectionURL;
     try {
        conn = DriverManager.getConnection(connectionURL, username, password);
     } catch (SQLException e) {
        System.out.println(e);
        return;
     }
  }
  public void test() {
     try {
        Statement test = conn.createStatement();
        ResultSet results = test.executeQuery("select * from items");
        ResultSetMetaData rsmd = results.getMetaData();
        int number = rsmd.getColumnCount();
        System.out.printf("Number of columns: %d", number);
        System.out.println("Column name of 1st column : " + rsmd.getColumnName(1));
        System.out.println("Column type of 1st column : " + rsmd.getColumnTypeName(1));
     } catch (SQLException e) {
        System.out.println(e);
     }
  }
  public boolean addItem (String tableName, String[] values) {
     String command = "INSERT INTO " + tableName +
                       " VALUES (" + (new String(new char[values.length]).replace("\0", ", ?").substring(2) + ")");
     try {
        PreparedStatement ps = conn.prepareStatement(command);
        for (int i = 1; i <= values.length; i++) {
           ps.setString(i, values[i - 1]);
        }
        ps.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e);
         return false;
     }
     return true;
  }
  public boolean removeItem (String tableName, String[][] constraints) {
     String command = "DELETE FROM " + tableName + " WHERE ";
     for (String[] param : constraints) {
        command = command + param[0] + "=? AND ";
     }
     try {
        PreparedStatement ps = conn.prepareStatement(command.substring(0, (command.length() - 5)));
        for (int i = 1; i <= constraints.length; i++) {
           ps.setString(i, constraints[i - 1][1]);
        }
        ps.executeUpdate();
     } catch (SQLException e) {
        System.out.println(e);
        return false;
     }
     return true;
  }
  public void close() {
     try {
         if (conn != null)
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
    }
}
