package INFI.assignement;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

public class CSVReader {

    static Optional<ArrayList<Camera>> readCamerasFromCSV(String fileName, String input) {
    	
        ArrayList<Camera> cameraList = new ArrayList<Camera>();
    	Path pathToFile = Paths.get(fileName);
        
    	try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
    		//read and discard columns
    		br.readLine();
    		String line = br.readLine();
        	
            while(line != null) {
            	if(Pattern.compile(Pattern.quote(input), Pattern.CASE_INSENSITIVE).matcher(line).find() && !line.contains("ERROR")) {
	        		Camera camera = createCamera(line);
	        		cameraList.add(camera);
	         	}
            	line = br.readLine();
    		}

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    	Optional<ArrayList<Camera>> cameras = Optional.of(cameraList);
        return cameras;
    }

    private static Camera createCamera(String line) {
    	Camera camera = new Camera();
		camera.name = line.substring(0,10);
		camera.index = line.substring(7,10);
    	camera.address = line.substring(11 , line.indexOf(';'));
    	camera.location = line.substring(line.indexOf(';')+1).replaceAll(";", " | ");
    	return camera;
    }

}
