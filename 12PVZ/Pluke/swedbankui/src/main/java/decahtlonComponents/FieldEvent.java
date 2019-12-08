package decahtlonComponents;

/**
 * Created by Viktorija on 4/15/2017.
 */
public class FieldEvent {

    private double meterRecord;
    private double metParamA;
    private double metParamB;
    private double metParamC;

    public FieldEvent() {
    }

    public FieldEvent(double athleteRecord, double paramA, double paramB, double paramC){
        this.meterRecord = athleteRecord;
        this.metParamA = paramA;
        this.metParamB = paramB;
        this.metParamC = paramC;
    }

    public double getMeterRecord() {
        return meterRecord;
    }

    public void setMeterRecord(double meterRecord) {
        this.meterRecord = meterRecord;
    }

    public double getMetParamA() {
        return metParamA;
    }

    public void setMetParamA(double metParamA) {
        this.metParamA = metParamA;
    }

    public double getMetParamB() {
        return metParamB;
    }

    public void setMetParamB(double metParamB) {
        this.metParamB = metParamB;
    }

    public double getMetParamC() {
        return metParamC;
    }

    public void setMetParamC(double metParamC) {
        this.metParamC = metParamC;
    }
}
