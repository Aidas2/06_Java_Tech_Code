package inputOutputComponents;

import decahtlonComponents.Athlete;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Viktorija on 4/16/2017.
 */
@XmlRootElement(name = "decathlon")
public class Decathlon {

    private List<Athlete> athletes;

    @XmlElement(name = "athlete")
    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
            this.athletes = athletes;
        }
}
