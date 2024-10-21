package ro.emanuel.piano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.piano.helper.DBHelper;
import ro.emanuel.piano.pojo.Piano;



public class PianoDAO {

	public static List<Piano> getPianos() throws SQLException {
        List<Piano> pianos = new ArrayList<>();

      
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from piano");
        while(rs.next()) {
 
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            int price = rs.getInt("price");
            String color = rs.getString("color");
            Piano piano = new Piano(id, brand, price, color);
            pianos.add(piano); 
        }
        
        DBHelper.closeConnection(); 
        
        return pianos; 
    }


    public static int deletePiano(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
     
        int deletedRows = stmt.executeUpdate("delete from piano where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

  
    public static int createPiano(Piano pianoToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into piano (brand, price, color) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
  
        ps.setString(1, pianoToCreate.getBrand());
        ps.setInt(2, pianoToCreate.getPrice());
        ps.setString(3, pianoToCreate.getColor());
        
    
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }


    public static int updatePiano(Piano piano) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update piano set brand = ?, price = ?, color = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, piano.getBrand());
        ps.setInt(2, piano.getPrice());
        ps.setString(3, piano.getColor());
        ps.setInt(4, piano.getId());
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }


    public static Piano getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
 
        List<Piano> pianos = getPianos();
        for(Piano b : pianos) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
    
        return null;
    }
}
