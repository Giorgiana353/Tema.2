package ro.emanuel.rubikscube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.rubikscube.helper.DBHelper;
import ro.emanuel.rubikscube.pojo.RubiksCube;

public class RubiksCubeDAO {

	public static List<RubiksCube> getRubiksCubes() throws SQLException {
        List<RubiksCube> rubiksCubes = new ArrayList<>();

      
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from rubikscube");
        while(rs.next()) {
 
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            int weight = rs.getInt("weight");
            int sides = rs.getInt("sides");
            RubiksCube rubiksCube = new RubiksCube(id, brand, weight, sides);
            rubiksCubes.add(rubiksCube); 
        }
        
        DBHelper.closeConnection(); 
        
        return rubiksCubes; 
    }


    public static int deleteRubiksCube(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
     
        int deletedRows = stmt.executeUpdate("delete from rubikscube where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

  
    public static int createRubiksCube(RubiksCube rubikscubeToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into rubikscube (brand, weight, sides) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
  
        ps.setString(1, rubikscubeToCreate.getBrand());
        ps.setInt(2, rubikscubeToCreate.getWeight());
        ps.setInt(3, rubikscubeToCreate.getSides());
        
    
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }


    public static int updateRubiksCube(RubiksCube rubikscube) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update rubikscube set brand = ?, weight = ?, sides = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, rubikscube.getBrand());
        ps.setInt(2, rubikscube.getWeight());
        ps.setInt(3, rubikscube.getSides());
        ps.setInt(4, rubikscube.getId());
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }


    public static RubiksCube getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
 
        List<RubiksCube> RubiksCubes = getRubiksCubes();
        for(RubiksCube b : RubiksCubes) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
    
        return null;
    }
}
