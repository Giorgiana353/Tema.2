package ro.emanuel.rubikscube.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.rubikscube.dao.RubiksCubeDAO;
import ro.emanuel.rubikscube.pojo.RubiksCube;



public class Main {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		List<RubiksCube> rubiksCubes = RubiksCubeDAO.getRubiksCubes();
        System.out.println("Lista cartilor:");
        for (RubiksCube rubiksCube : rubiksCubes) {
            System.out.println(rubiksCube);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
        // 2. Cream 
        RubiksCube newRubiksCube = new RubiksCube("Cub Nou", 30, 5);
        int rowsInserted = RubiksCubeDAO.createRubiksCube(newRubiksCube);
        System.out.println("Cub nou a fost creat. Rinduri inserate: " + rowsInserted);
        


        // 3. 
        RubiksCube RubiksCube = RubiksCubeDAO.getById(3);
        System.out.println("Cub gasit dupa ID: " + RubiksCube);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



        // 4. Facem update 
        RubiksCube RubiksCubeToUpdate = new RubiksCube(3, "yyt", 54, 2);
        int rowsUpdated = RubiksCubeDAO.updateRubiksCube(RubiksCubeToUpdate);
        System.out.println("Cubul a fost actualizat. Rinduri updatate: " + rowsUpdated);
        RubiksCube = RubiksCubeDAO.getById(3);
        System.out.println("Cub actualizat: " + RubiksCube);

        
        // 5. Stergem 
        int rowsDeleted = RubiksCubeDAO.deleteRubiksCube(3);
        System.out.println("Cubul a fost stears. Rinduri sterse: " + rowsDeleted);
        RubiksCube = RubiksCubeDAO.getById(3);
        System.out.println(RubiksCube);
	
        }

}
