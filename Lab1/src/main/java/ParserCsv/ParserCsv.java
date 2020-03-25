package ParserCsv;

import com.company.DataMas;
import com.company.Division;
import com.company.Person;
import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ParserCsv {
    private static Logger logger = Logger.getLogger(ParserCsv.class);
    private static final int ID_INDEX = 0;
    private static final int FIRST_NAME_INDEX = 1;
    private static final int GENDER_INDEX = 2;
    private static final int BIRTH_DATE_INDEX = 3;
    private static final int DIVISION_INDEX = 4;
    private static final int SALARY_INDEX = 5;

    private  List<String> lines = new ArrayList<String>();

    public List<String> getLines() {
        return lines;
    }

    private List<IDivision> divisions =  new ArrayList<>();

    public void setLines() {

    }


    public void read(final String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        reader.readLine();
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            lines.add(currentLine);
        }
    }

    public IRepository<IPerson> parse(){
        logger.trace("Parse started");
        DataMas<IPerson> dataMas = new DataMas<IPerson>();
        for (String line : lines) {
            String[] subStr = line.split(";");
            IDivision current_division = check_division(subStr);
            Person person = new Person(Integer.parseInt(subStr[ID_INDEX]),
                    subStr[FIRST_NAME_INDEX], "",
                    subStr[GENDER_INDEX].equals("Male") ? Gender.MALE : (subStr[GENDER_INDEX].equals("Female") ? Gender.FEMALE : null),
                    LocalDate.parse(subStr[BIRTH_DATE_INDEX],
                            DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.US)),
                    new BigDecimal(subStr[SALARY_INDEX]),
                    current_division);
            logger.debug("Person created" + person.toString());
            dataMas.add(person);
        }
        return dataMas;
    }

    private IDivision check_division(String[] subStr){
        if(!divisions.isEmpty()){
            for (IDivision division : divisions) {
                if (division.getName().equals(subStr[DIVISION_INDEX])){
                    return division;
                }
            }
        }
        divisions.add(new Division(subStr[DIVISION_INDEX]));
        return  new Division(subStr[DIVISION_INDEX]);
    }


}