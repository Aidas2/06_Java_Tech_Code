package decahtlonComponents;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class TrackEvent {

    private double secondsRecord;
    private double secParamA;
    private double secParamB;
    private double secParamC;

    public TrackEvent(){
    }

    public TrackEvent(double secRecord, double paramA, double paramB, double paramC) {
        this.secondsRecord = secRecord;
        this.secParamA = paramA;
        this.secParamB = paramB;
        this.secParamC = paramC;
    }

    public double getSecondsRecord() {
        return secondsRecord;
    }

    public void setSecondsRecord(double secondsRecord) {
        this.secondsRecord = secondsRecord;
    }

    public double getSecParamA() {
        return secParamA;
    }

    public void setSecParamA(double secParamA) {
        this.secParamA = secParamA;
    }

    public double getSecParamB() {
        return secParamB;
    }

    public void setSecParamB(double secParamB) {
        this.secParamB = secParamB;
    }

    public double getSecParamC() {
        return secParamC;
    }

    public void setSecParamC(double secParamC) {
        this.secParamC = secParamC;
    }
}
