package JAXB;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb {
    private static Logger logger = Logger.getLogger(Jaxb.class);

    public static void toXml(Object obj, String filePath) {
        try {
            logger.debug("Converting to XML started");
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e){
            logger.error(e.getMessage());
        }
    }

    public static Object fromXml(String filePath, Class<?> clazz) {
        try {
            logger.debug("Converting from XML started");
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e){
            logger.error(e.getMessage());
        }
        return null;
    }
}
