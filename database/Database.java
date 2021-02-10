package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
     // initalizing all variables
     String url = "jdbc:mysql://localhost:3306/tbl_graph";
     String username = "root";
     String password = "";
     String sql = "";
     PreparedStatement stmt1, stmt2;
     ResultSet rs1, rs2;
     Connection con;

     public Database() {

          try {
               // setting database
               con = DriverManager.getConnection(url, username, password);
               rs1 = stmt1.executeQuery();
               rs1.next();
               stmt1.close();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }

     // add khata database code goes here
     public void addKhata(String id, String title, String description, String price, String date, String remarks)
               throws SQLException {
          con = getConnection();
          String sql = "insert into vertex values(?,?,?,?,?,?)";
          stmt1 = con.prepareStatement(sql);
          stmt1.setString(1, id);
          stmt1.setString(2, title);
          stmt1.setString(3, description);
          stmt1.setString(4, price);
          stmt1.setString(5, date);
          stmt1.setString(6, remarks);
          stmt1.executeUpdate();
          stmt1.close();
          con.close();
     }

     // view khata database code goes here
     public ResultSet viewKhata(String id) throws SQLException {
          con = getConnection();
          String sql = "select * from vertex where id = ?";
          stmt1 = con.prepareStatement(sql);
          stmt1.setString(1, id);
          return stmt1.executeQuery();
     }

     // delete khata datbase code goes here
     public void deleteKhata(String id) throws SQLException {
          con = getConnection();
          String sql = "delete from vertex where id = ?";
          stmt1 = con.prepareStatement(sql);
          stmt1.setString(1, id);
          stmt1.executeUpdate();
          stmt1.close();
          con.close();
     }

     // update khata datbase code goes here
     public void updateKhata(String id, String title, String description, String price, String date, String remarks)
               throws SQLException {
          con = getConnection();
          String sql = "update vertex set title =?, description = ?, price=?, date=?,remarks=? where id=?";
          stmt1 = con.prepareStatement(sql);
          stmt1.setString(1, title);
          stmt1.setString(2, description);
          stmt1.setString(3, price);
          stmt1.setString(4, date);
          stmt1.setString(5, remarks);
          stmt1.setString(6, id);
          stmt1.executeUpdate();
          stmt1.close();
          con.close();

     }

     private Connection getConnection() throws SQLException {
          return DriverManager.getConnection(url, username, password);
     }

}
