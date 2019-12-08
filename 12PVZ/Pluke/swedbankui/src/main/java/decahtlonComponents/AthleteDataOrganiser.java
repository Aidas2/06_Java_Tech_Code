package decahtlonComponents;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class AthleteDataOrganiser {

    private static final int dataInLine = 11;

    //track events ABC params
    private static final double[] hundredMetABC = {25.4347, 18, 1.81};
    private static final double[] fourHundredMetABC = {1.53775, 82, 1.81};
    private static final double[] hundredTenMetABC = {5.74352, 28.5, 1.92};
    private static final double[] fifteenHundredMetABC = {0.03768, 480, 1.85};

    //field events ABC params
    private static final double[] longJumpABC = {0.14354, 220, 1.4};
    private static final double[] shotPutABC = {51.39, 1.5, 1.05};
    private static final double[] highJumpABC = {0.8465, 75, 1.42};
    private static final double[] discusThrowABC = {12.91, 4, 1.1};
    private static final double[] poleVaultABC = {0.2797, 100, 1.35};
    private static final double[] javelinThrowABC = {10.14, 7, 1.08};

    public static void organiseDataFromFile(String fileInput, Athlete athlete){
        checkDataInLine(fileInput);
        athlete.setRecordsFromFile(fileInput);
        String[] parts = fileInput.split(";");
        String athleteName = parts[0];
        String trackEvent100 = parts[1];
        String fieldEvenLJ = parts[2];
        String fieldEventSP = parts[3];
        String fieldEventHJ = parts[4];
        String trackEvent400 = parts[5];
        String trackEvent110 = parts[6];
        String fieldEventDT = parts[7];
        String fieldEventPV = parts[8];
        String fieldEventJT = parts[9];
        String trackEvent1500 = parts[10];
        athlete.setFullName(athleteName);
        String[] values = trackEvent1500.split("\\.");
        double minInSec = Double.valueOf(values[0]) * 60;
        double millisInSec = Double.valueOf(values[2]) / 100;
        double fifteenHundredResultInSec = minInSec + Double.valueOf(values[1]) + millisInSec;
        double[] trackRecords = {Double.valueOf(trackEvent100), Double.valueOf(trackEvent400), Double.valueOf(trackEvent110), fifteenHundredResultInSec};
        athlete.setTrackRecords(trackRecords);
        List<TrackEvent> trackEvents = (populateAthleteTrackEvents(trackRecords));
        double[] fieldRecords = {Double.valueOf(fieldEvenLJ)*100, Double.valueOf(fieldEventSP), Double.valueOf(fieldEventHJ)*100,Double.valueOf(fieldEventDT), Double.valueOf(fieldEventPV)*100, Double.valueOf(fieldEventJT)};
        athlete.setFieldRecords(fieldRecords);
        List<FieldEvent> fieldEvents = (populateAthleteFieldEvents(fieldRecords));
        athlete.setTrackRecordScores(ScoreAndPlaceCalculator.calculateTrackEvents(trackEvents));
        athlete.setFieldRecordScores(ScoreAndPlaceCalculator.calculateFieldEvents(fieldEvents));
        athlete.setTotalScore(ScoreAndPlaceCalculator.countAthletTotalScore(athlete.getTrackRecordScores(), athlete.getFieldRecordScores()));
    }

    private static void checkDataInLine(String line){
        String[] parts = line.split(";");
        if(parts.length != dataInLine){
            throw new IllegalArgumentException("Data provided in file is not correct");
        }
    }

    protected static List<TrackEvent> populateAthleteTrackEvents(double[] trackRecords) {
        List<TrackEvent> allTracks = new ArrayList<TrackEvent>();
        TrackEvent hundredMet = new TrackEvent(trackRecords[0], hundredMetABC[0], hundredMetABC[1], hundredMetABC[2]);
        allTracks.add(hundredMet);
        TrackEvent fourHundredMet = new TrackEvent(trackRecords[1], fourHundredMetABC[0], fourHundredMetABC[1], fourHundredMetABC[2]);
        allTracks.add(fourHundredMet);
        TrackEvent hudredTenMet = new TrackEvent(trackRecords[2], hundredTenMetABC[0], hundredTenMetABC[1], hundredTenMetABC[2]);
        allTracks.add(hudredTenMet);
        TrackEvent fifteenHundredMet = new TrackEvent(trackRecords[3], fifteenHundredMetABC[0], fifteenHundredMetABC[1], fifteenHundredMetABC[2]);
        allTracks.add(fifteenHundredMet);
        return allTracks;
    }

    protected static List<FieldEvent> populateAthleteFieldEvents(double[] fieldRecords) {
        List<FieldEvent> allFields = new ArrayList<FieldEvent>();
        FieldEvent longJump = new FieldEvent(fieldRecords[0], longJumpABC[0], longJumpABC[1], longJumpABC[2]);
        allFields.add(longJump);
        FieldEvent shotPut = new FieldEvent(fieldRecords[1], shotPutABC[0], shotPutABC[1], shotPutABC[2]);
        allFields.add(shotPut);
        FieldEvent highJump = new FieldEvent(fieldRecords[2], highJumpABC[0], highJumpABC[1], highJumpABC[2]);
        allFields.add(highJump);
        FieldEvent discusThrow = new FieldEvent(fieldRecords[3], discusThrowABC[0], discusThrowABC[1], discusThrowABC[2]);
        allFields.add(discusThrow);
        FieldEvent paulVault = new FieldEvent(fieldRecords[4], poleVaultABC[0], poleVaultABC[1], poleVaultABC[2]);
        allFields.add(paulVault);
        FieldEvent javelinThrow = new FieldEvent(fieldRecords[5], javelinThrowABC[0], javelinThrowABC[1], javelinThrowABC[2]);
        allFields.add(javelinThrow);
        return allFields;
    }
}


