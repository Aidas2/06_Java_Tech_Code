package decahtlonComponents;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static decahtlonComponents.AthleteDataOrganiser.organiseDataFromFile;
import static decahtlonComponents.AthleteDataOrganiser.populateAthleteFieldEvents;
import static decahtlonComponents.AthleteDataOrganiser.populateAthleteTrackEvents;
import static org.junit.Assert.*;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class ScoreAndPlaceCalculatorTest extends ScoreAndPlaceCalculator {

    @Test
    public void testCalculateTheWinner() throws Exception {
        Athlete testAthlete1 = new Athlete();
        Athlete testAthlete2 = new Athlete();
        Athlete testAthlete3 = new Athlete();
        Athlete testAthlete4 = new Athlete();
        testAthlete1.setTotalScore(1500);
        testAthlete2.setTotalScore(2300);
        testAthlete3.setTotalScore(1000);
        testAthlete4.setTotalScore(1500);
        List<Athlete> participants = new ArrayList<Athlete>();
        participants.add(testAthlete1);
        participants.add(testAthlete2);
        participants.add(testAthlete3);
        participants.add(testAthlete4);

        setPlaceInDecathlon(participants);

        assertTrue("1".equals(testAthlete2.getPlaceInComptetition()));
        assertEquals(testAthlete1.getPlaceInComptetition(), testAthlete4.getPlaceInComptetition());
        assertEquals("2-3", testAthlete4.getPlaceInComptetition());
    }

    @Test
    public void countAthletTotalScore() throws Exception {
        Athlete testAthlete = new Athlete();
        organiseDataFromFile("Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75", testAthlete);
        double totalScore = countAthletTotalScore(testAthlete.getTrackRecordScores(), testAthlete.getFieldRecordScores());
        assertTrue(3499 == totalScore);
    }

    @Test
    public void countFieldEventScore() throws Exception {
        double score = countFieldEventScore(10.12, 51.39,	1.5,	1.05);
        assertTrue(493.0 == score);
    }

    @Test
    public void testCountTrackEventScore() throws Exception {
        double score = countTrackEventScore(11.756, 25.4347, 18, 1.81);
        assertTrue(700.0 == score);
    }

    @Test
    public void testCalculateTrackEvents() throws Exception {
        Athlete testAthlete = new Athlete();
        organiseDataFromFile("Beata Kana;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76", testAthlete);
        List<TrackEvent> trackEvents = populateAthleteTrackEvents(testAthlete.getTrackRecords());
        testAthlete.setTrackRecordScores(calculateTrackEvents(trackEvents));

        assertTrue(462.0 == testAthlete.getTrackRecordScores()[0]);
        assertTrue(267.0 == testAthlete.getTrackRecordScores()[1]);
        assertFalse(455 == testAthlete.getTrackRecordScores()[2]);
        assertFalse(95 == testAthlete.getTrackRecordScores()[3]);
    }

    @Test
    public void testCalculateFieldEvents() throws Exception {
        Athlete testAthlete = new Athlete();
        organiseDataFromFile("Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75", testAthlete);
        List<FieldEvent> fieldEvents = populateAthleteFieldEvents(testAthlete.getFieldRecords());
        testAthlete.setFieldRecordScores(calculateFieldEvents(fieldEvents));

        assertTrue(353.0 == testAthlete.getFieldRecordScores()[0]);
        assertTrue(493.0 == testAthlete.getFieldRecordScores()[1]);
        assertTrue(389.0 == testAthlete.getFieldRecordScores()[2]);
        assertFalse(480 == testAthlete.getFieldRecordScores()[3]);
        assertFalse(300 == testAthlete.getFieldRecordScores()[4]);
        assertFalse(350 == testAthlete.getFieldRecordScores()[5]);
    }

}