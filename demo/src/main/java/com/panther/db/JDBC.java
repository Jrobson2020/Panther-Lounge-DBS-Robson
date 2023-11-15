package com.panther.db;

import java.sql.*;
import javax.sql.DataSource;
import com.panther.details.itemDetails;

public class JDBC {

    public boolean addItem (String tableName, String[] values) {
        String command = "INSERT INTO " + tableName +
                       " VALUES (" + (new String(new char[values.length]).replace("\0", ", ?").substring(2) + ")");
        
        executeUpdate(command, values);
        return true;
    }
    public boolean addItem (itemDetails item) {
       String command = "INSERT INTO items" +
                      " VALUES (?,?,?,?,?,?,?,?,?)";
                      
       String[] values = new String[9];
       values[0] = item.getId();
       values[1] = item.getName();
       values[2] = item.getType();
       values[3] = item.getShelf();
       values[4] = item.getClub();
       values[5] = item.getSeries();
       values[6] = item.getStatus();
       values[7] = item.getRating();
       values[8] = item.getDesc();
       
       if (executeUpdate(command, values))
          return true;
       else
          return false;
   }
    
    //public String constructParams(String[][] params)
    
    public boolean removeItem (String tableName, String[][] constraints) {
        String command = "DELETE FROM " + tableName + " WHERE ";
        for (String[] param : constraints) {
            command = command + param[0] + "=? AND ";
        }
        
        try {
            DataSource dataSource = configDataSource.source();
            Connection conn = dataSource.getConnection();
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
    
    public ResultSet search (String tableName) {
       String command = "SELECT * FROM " + tableName;
       System.out.println(command);
       
       ResultSet rs = null;
       try {
          DataSource dataSource = configDataSource.source();
          Connection conn = dataSource.getConnection();
          PreparedStatement ps = conn.prepareStatement(command);
          rs = ps.executeQuery();
      } catch (SQLException e) {
          System.out.println(e);
      }
       return rs;
    }
    
    public ResultSet search (String tableName, String[][] params) {
       String command = "SELECT * FROM " + tableName + " WHERE ";
    
       for (String[] param : params) {
          command = command + param[0] + "=? AND ";
       }
       
       ResultSet rs = null;
       try {
          DataSource dataSource = configDataSource.source();
          Connection conn = dataSource.getConnection();
          PreparedStatement ps = conn.prepareStatement(command.substring(0, (command.length() - 5)));
          for (int i = 1; i <= params.length; i++) {
              ps.setString(i, params[i - 1][1]);
          }
          rs = ps.executeQuery();
      } catch (SQLException e) {
          System.out.println(e);
      }
       return rs;
    }
    
    public boolean executeUpdate(String command, String[] wildcards) {
       try {
          DataSource dataSource = configDataSource.source();
          Connection conn = dataSource.getConnection();
          PreparedStatement ps = conn.prepareStatement(command);
          for (int i = 1; i <= wildcards.length; i++) {
              ps.setString(i, wildcards[i - 1]);
          }
          ps.executeUpdate();
      } catch (SQLException e) {
          System.out.println(e);
          return false;
      }
      return true;
    }
    

}