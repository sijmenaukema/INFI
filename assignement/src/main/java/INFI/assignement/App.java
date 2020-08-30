package INFI.assignement;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Initializing...");
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Type your query");
    	String input = sc.nextLine();
    	sc.close();
    	
    	Path currentRelativePath = Paths.get("");
    	String currentPath = currentRelativePath.toAbsolutePath().toString();
    	
    	Optional<ArrayList<Camera>> cameras = CSVReader.readCamerasFromCSV(String.format("%s/cameras-defb.csv", currentPath), input ) ; 
    	if(cameras.isPresent()){
    		ArrayList<Camera> cameraList = (ArrayList<Camera>) cameras.get();
    		for(Camera camera: cameraList) {
    			System.out.println(String.format("%s | %s | %s | %s ",camera.index, camera.name, camera.address, camera.location));	
    		}
    		if(cameraList.size() == 0) System.out.println("No results found");
    		System.out.println("exiting...");
    		System.exit(0);
		}
	}
}

