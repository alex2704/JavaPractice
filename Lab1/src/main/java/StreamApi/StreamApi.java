package StreamApi;
import ru.vsu.lab.entities.IPerson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {
    /**
     *
     * @param listPerson список
     * @return Map которая содержит названия подразделений и суммы зарплат.
     */
    public Map getMapDivisionSalary(List<IPerson> listPerson) {
        Map<String, List<IPerson>> a1 = listPerson.stream().collect(Collectors.groupingBy(p -> p.getDivision().getName()));

        return a1.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        p -> p.getValue()
                                .stream()
                                .map(IPerson::getSalary).reduce(BigDecimal::add).get()));
    }

    /**
     *
     * @param listPerson список
     * @return Выдать(поместить в список) людей которые старше 30 лет, в фамилии есть буква А, зарплата которых < 5000
     */
    public Map getMapSortbySurnameAndSalary5000(List<IPerson> listPerson){
        return listPerson.stream().filter(p -> p.getAge() > 30 &&
                                          p.getLastName().toLowerCase().contains("а") &&
                                          p.getSalary().compareTo(new BigDecimal(5000)) < 0)
                                          .collect(Collectors.toMap(IPerson::getId, p -> p));
    }

    /**
     *
     * @param listPerson список людей
     * @return список людей в которых идут 2 буквы 'а' подряд
     */
    public Map getMapContractAA(List<IPerson> listPerson){
        return listPerson.stream().filter(p -> p.getLastName().toLowerCase().contains("а"))
                                   .collect(Collectors.toMap(IPerson::getId, p -> p));
    }

    /**
     *
     * @param listPerson список
     * @return Выдает год рождения и сколько людей было рождено в этот год
     */
    public Map getMapCountPersonByYear(List<IPerson> listPerson){
        return listPerson.stream().collect(Collectors.groupingBy(p -> p.getBirthdate().getYear(), Collectors.counting()));
    }

}
