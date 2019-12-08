package decahtlonComponents;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class AthleteDataOrganiserTest extends AthleteDataOrganiser {

    @Test
    public void testOrganisingDataFromFile(){
        Athlete testAthlete = new Athlete();
        organiseDataFromFile("Beata Kana;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76", testAthlete);
        assertEquals("Beata Kana", testAthlete.getFullName());
        assertTrue(testAthlete.getTrackRecords()[3] == 410.76 );
        assertTrue(testAthlete.getFieldRecords()[0] == 453);
    }

    @Test
    public void testPopulateAthleteTrackEvents() throws Exception {
        Athlete testAthlete = new Athlete();
        organiseDataFromFile("Jaana Lind;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75", testAthlete);
        List<TrackEvent> tracks = populateAthleteTrackEvents(testAthlete.getTrackRecords());
        assertNotNull(tracks);
        assertFalse(tracks.isEmpty());
        assertTrue(tracks.get(0).getSecondsRecord() == 13.75);
        assertTrue(tracks.get(0).getSecParamA() == 25.4347);
        assertTrue(tracks.get(0).getSecParamB() == 18);
        assertTrue(tracks.get(0).getSecParamC() == 1.81);
    }

    @Test
    public void testPopulateAthleteFieldEvents() throws Exception {
        Athlete testAthlete = new Athlete();
        organiseDataFromFile("Anti Loop;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01", testAthlete);
        List<FieldEvent> fields = populateAthleteFieldEvents(testAthlete.getFieldRecords());
        assertNotNull(fields);
        assertFalse(fields.isEmpty());
        assertTrue(fields.get(5).getMeterRecord() == 33.48);
        assertTrue(fields.get(5).getMetParamA() == 10.14);
        assertTrue(fields.get(5).getMetParamB() == 7);
        assertTrue(fields.get(5).getMetParamC() == 1.08);
    }

}