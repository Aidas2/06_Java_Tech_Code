package inputOutputComponents;

import decahtlonComponents.Athlete;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Viktorija on 4/16/2017.
 */
public class OutPutController {

    private String outputFile;
    private static final String stylingSheetXSL = "xsl/decathlon.xsl";
    private static final String requiredExtension = ".xml";
    private static final String browserFriendlyExtension = ".html";


    public void createOutputFiles(List<Athlete> athleteList) {

        try {
            JAXBContext context = JAXBContext.newInstance(Decathlon.class);
            Marshaller marshaller = context.createMarshaller();

            Decathlon decathlon = loadDataForOutput(athleteList);

            marshaller.marshal(decathlon, new FileOutputStream(getOutputFile() + requiredExtension));

            TransformerFactory tfac = TransformerFactory.newInstance();

            StreamSource xsl = new StreamSource(getClass().getClassLoader().getResourceAsStream(stylingSheetXSL));

            JAXBSource source = new JAXBSource(context, decathlon);
            StreamResult result = new StreamResult(new FileOutputStream(getOutputFile() + browserFriendlyExtension));
            tfac.newTransformer(xsl).transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OutPutController(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    private static Decathlon loadDataForOutput(List<Athlete> athleteList) {
        Decathlon decathlon = new Decathlon();
        decathlon.setAthletes(athleteList);
        return decathlon;
    }
}
