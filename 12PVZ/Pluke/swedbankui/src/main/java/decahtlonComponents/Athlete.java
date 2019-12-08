package decahtlonComponents;

import java.util.List;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class Athlete {

    private String fullName;
    private double totalScore;
    private String placeInComptetition;
    private double[] trackRecords;
    private double[] fieldRecords;
    private double[] trackRecordScores;
    private double[] fieldRecordScores;
    private String recordsFromFile;

    public Athlete() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRecordsFromFile() {
        return recordsFromFile;
    }

    public void setRecordsFromFile(String recordsFromFile) {
        this.recordsFromFile = recordsFromFile;
    }

    public double[] getTrackRecords() {
        return trackRecords;
    }

    public void setTrackRecords(double[] trackRecords) {
        this.trackRecords = trackRecords;
    }

    public double[] getFieldRecords() {
        return fieldRecords;
    }

    public void setFieldRecords(double[] fieldRecords) {
        this.fieldRecords = fieldRecords;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public String getPlaceInComptetition() {
        return placeInComptetition;
    }

    public void setPlaceInComptetition(String placeInComptetition) {
        this.placeInComptetition = placeInComptetition;
    }

    public double[] getTrackRecordScores() {
        return trackRecordScores;
    }

    public void setTrackRecordScores(double[] trackRecordScores) {
        this.trackRecordScores = trackRecordScores;
    }

    public double[] getFieldRecordScores() {
        return fieldRecordScores;
    }

    public void setFieldRecordScores(double[] fieldRecordScores) {
        this.fieldRecordScores = fieldRecordScores;
    }
}
