package decahtlonComponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Viktorija on 4/15/2017.
 */
public class ScoreAndPlaceCalculator {


    protected static double[] calculateTrackEvents(List<TrackEvent> trackEvents) {
        double[] trackEventsScores = new double[4];
        List<Double> tracks = new ArrayList<Double>();

        for (TrackEvent event : trackEvents) {
            double score = countTrackEventScore(event.getSecondsRecord(), event.getSecParamA(), event.getSecParamB(), event.getSecParamC());
            tracks.add(score);
        }

        for(int i = 0; i < tracks.size(); i++) trackEventsScores[i] = tracks.get(i);

        return trackEventsScores;

    }

    protected static double[] calculateFieldEvents(List<FieldEvent> fieldEvents) {
        List<Double> fields = new ArrayList<Double>();
        double[] fieldEventsScores = new double[6];

        for (FieldEvent event : fieldEvents) {
            double score = countFieldEventScore(event.getMeterRecord(), event.getMetParamA(), event.getMetParamB(), event.getMetParamC());
            fields.add(score);
        }

        for(int i = 0; i < fields.size(); i++) fieldEventsScores[i] = fields.get(i);

        return fieldEventsScores;

    }

    protected static double countAthletTotalScore(double[] trackScores, double[] fieldScores){
        double sumTrack = 0;
        for (double n : trackScores) {
            sumTrack += n;
        }
        double sumField = 0;
        for (double k : fieldScores) {
            sumField += k;
        }
        return sumTrack + sumField;
    }

    protected static List<Athlete> sortAthletsByScores(List<Athlete> participants) {
        Collections.sort(participants, new Comparator<Athlete>() {
            public int compare(Athlete o1, Athlete o2) {
                return o1.getTotalScore() > o2.getTotalScore() ? -1 : (o1.getTotalScore() < o2.getTotalScore() ) ? 1 : 0;
            }
        });
        return participants;
    }

    public static void setPlaceInDecathlon(List<Athlete> participants){
        participants = sortAthletsByScores(participants);
        Athlete previousAthlete = null;
        int currentPosition = 1;
        for (Athlete participant : participants) {
            if (previousAthlete == null || previousAthlete.getTotalScore() != participant.getTotalScore()) {
                participant.setPlaceInComptetition(String.valueOf(currentPosition));
            } else {
                participant.setPlaceInComptetition(previousAthlete.getPlaceInComptetition());
            }
            previousAthlete = participant;
            currentPosition++;

        }
        String place = participants.get(0).getPlaceInComptetition();
        for(int i = 1; i < participants.size()-1; i++){
            if(participants.get(i).getPlaceInComptetition().equals(place)){
                participants.get(i).setPlaceInComptetition(arrangeEqualPlaces(participants.get(i).getPlaceInComptetition()));
                participants.get(i-1).setPlaceInComptetition(arrangeEqualPlaces(participants.get(i-1).getPlaceInComptetition()));
            }
            else {
                place = String.valueOf(Integer.valueOf(place) + 1);
            }
        }
    }

    protected static String arrangeEqualPlaces (String place){
        int nextPlace = Integer.valueOf(place) + 1;
        return place + "-" + String.valueOf(nextPlace);
    }


    protected static double countTrackEventScore(double athleteRecord, double paramA, double paramB, double paramC) {
        double score = paramA * Math.pow(paramB - athleteRecord, paramC);
        score = Double.valueOf(Math.round(score));
        return score;
    }

    protected static double countFieldEventScore(double athleteRecord, double paramA, double paramB, double paramC) {
        double score = paramA * Math.pow(athleteRecord - paramB, paramC);
        score = Double.valueOf(Math.round(score));
        return score;
    }

}
