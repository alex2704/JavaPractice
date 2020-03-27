package JAXB;

import com.company.Division;
import ru.vsu.lab.entities.IDivision;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterDivisionXml extends XmlAdapter<String, IDivision> {
    @Override
    public IDivision unmarshal(String v) throws Exception{
        return new Division(v);
    }

    @Override
    public String marshal(IDivision v) throws Exception {
        return v != null ? v.getName() : "not exist";
    }
}
