import decahtlonComponents.Athlete;
import decahtlonComponents.ScoreAndPlaceCalculator;
import inputOutputComponents.InputController;
import inputOutputComponents.OutPutController;

import java.util.List;

/**
 * Created by Viktorija on 4/16/2017.
 */
public class DecathlonApplication {

    private static InputController inputController;
    private static OutPutController outPutController;


    public static void main(String args[]) {
        if (createControllers(args)) {
            proceedFiles();
        }
    }

    private static boolean createControllers(String args[]) {
        if (args == null || args.length != 2) {
            System.out.println("Input / Output files were not provided");
            return false;
        }

        inputController = new InputController(args[0]);
        outPutController = new OutPutController(args[1]);
        return true;
    }

    public static void proceedFiles() {
        inputController.readDataFromFile();
        System.out.println("Done reading data from input file");
        List<Athlete> athletes = inputController.getAllAthletes();
        ScoreAndPlaceCalculator.setPlaceInDecathlon(athletes);
        System.out.println("Counted total points and awarded winners");
        outPutController.createOutputFiles(athletes);
        System.out.println("Successfully created output files");
    }
}
