package ro.emanuel.book.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.book.dao.BookDAO;
import ro.emanuel.book.pojo.Book;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		List<Book> books = BookDAO.getBooks();
        System.out.println("Lista cartilor:");
        for (Book book : books) {
            System.out.println(book);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
        // 2. Cream 
        Book newBook = new Book("Carte Noua", 300, 45);
        int rowsInserted = BookDAO.createBook(newBook);
        System.out.println("Cartea noua a fost creata. Rinduri inserate: " + rowsInserted);
        


        // 3. 
        Book book = BookDAO.getById(3);
        System.out.println("Cartea gasita dupa ID: " + book);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



        // 4. Facem update 
        Book bookToUpdate = new Book(3, "Enigma Otiliei", 544, 120);
        int rowsUpdated = BookDAO.updateBook(bookToUpdate);
        System.out.println("Cartea a fost actualizata. Rinduri updatate: " + rowsUpdated);
        book = BookDAO.getById(3);
        System.out.println("Cartea actualizata: " + book);

        
        // 5. Stergem 
        int rowsDeleted = BookDAO.deleteBook(3);
        System.out.println("Cartea a fost stearsa. Rinduri sterse: " + rowsDeleted);
        book = BookDAO.getById(3);
        System.out.println(book);
	}

}
