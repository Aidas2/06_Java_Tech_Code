package inputOutputComponents;

import decahtlonComponents.Athlete;
import decahtlonComponents.AthleteDataOrganiser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class InputController {

    private String inputFile;
    private final static String inputFileExtention = ".txt";
    private List<Athlete> allAthletes = new ArrayList<Athlete>();

    public InputController(String inputFile) {
        this.inputFile = inputFile + inputFileExtention;
    }

    public void readDataFromFile() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Athlete athlete = new Athlete();
            AthleteDataOrganiser.organiseDataFromFile(line, athlete);
            allAthletes.add(athlete);
        }
        scanner.close();
    }

    public List<Athlete> getAllAthletes() {
        return allAthletes;
    }
}
