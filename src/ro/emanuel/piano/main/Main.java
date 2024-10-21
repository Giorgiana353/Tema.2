package ro.emanuel.piano.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.piano.dao.PianoDAO;
import ro.emanuel.piano.pojo.Piano;



public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		List<Piano> pianos = PianoDAO.getPianos();
        System.out.println("Lista pianelor:");
        for (Piano piano : pianos) {
            System.out.println(piano);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
        // 2. Cream 
        Piano newPiano = new Piano("Pian Nou", 30000, "negru");
        int rowsInserted = PianoDAO.createPiano(newPiano);
        System.out.println("Pian nou a fost creata. Rinduri inserate: " + rowsInserted);
        


        // 3. 
        Piano piano = PianoDAO.getById(3);
        System.out.println("Pian gasit dupa ID: " + piano);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



        // 4. Facem update 
        Piano pianoToUpdate = new Piano(3, "SSh", 54004, "white");
        int rowsUpdated = PianoDAO.updatePiano(pianoToUpdate);
        System.out.println("Pianul a fost actualizata. Rinduri updatate: " + rowsUpdated);
        piano = PianoDAO.getById(3);
        System.out.println("Pianul actualizat: " + piano);

        
        // 5. Stergem 
        int rowsDeleted = PianoDAO.deletePiano(3);
        System.out.println("Pianul a fost stears. Rinduri sterse: " + rowsDeleted);
        piano = PianoDAO.getById(3);
        System.out.println(piano);
	
        }

}
