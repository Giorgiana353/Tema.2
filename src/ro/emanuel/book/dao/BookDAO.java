package ro.emanuel.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.book.helper.DBHelper;
import ro.emanuel.book.pojo.Book;


public class BookDAO {
	

    public static List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

      
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from book");
        while(rs.next()) {
 
            int id = rs.getInt("id");
            String title = rs.getString("title");
            int pages = rs.getInt("pages");
            int price = rs.getInt("price");
            Book book = new Book(id, title, pages, price);
            books.add(book); 
        }
        
        DBHelper.closeConnection(); 
        
        return books; 
    }


    public static int deleteBook(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
     
        int deletedRows = stmt.executeUpdate("delete from book where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; 
    }

  
    public static int createBook(Book bookToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into book (title, pages, price) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
  
        ps.setString(1, bookToCreate.getTitle());
        ps.setInt(2, bookToCreate.getPages());
        ps.setInt(3, bookToCreate.getPrice());
        
    
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; 
    }


    public static int updateBook(Book book) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update book set title = ?, pages = ?, price = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, book.getTitle());
        ps.setInt(2, book.getPages());
        ps.setInt(3, book.getPrice());
        ps.setInt(4, book.getId());
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }


    public static Book getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
 
        List<Book> books = getBooks();
        for(Book b : books) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
    
        return null;
    }
}
