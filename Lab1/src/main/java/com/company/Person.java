package com.company;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Person implements IPerson {
    /**
     * поле идентификатор
     */
    private Integer id;

    /**
     * имя
     */
    private String firstName;

    /**
     * фамилия
     */
    private String lastName;

    /**
     * пол
     */
    private Gender gender;

    /**
     * дата дня рождения человека
     */
    private LocalDate birthdate;

    /**
     * классификация
     */
    private IDivision division;

    /**
     * зарплата
     */
    private BigDecimal salary;

    /**
     *
     * @param id идентификатор
     * @param firstName имя
     * @param lastName фамилия
     * @param gender пол
     * @param birthdate дата рождения
     * @param salary зарплата
     * @param division классификация
     */
    public Person(Integer id, String firstName, String lastName, Gender gender, LocalDate birthdate, BigDecimal salary,
                  IDivision division){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.salary = salary;
        this.division = division;
    }

    /**
     * @return  идентификатор
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id идентификатор
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return  пол
     */
    @Override
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender пол
     */
    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return фамилия
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName фамилия
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return имя
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName имя
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return дата рождения
     */
    @Override
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthDate дата рождения
     */
    @Override
    public void setBirthdate(LocalDate birthDate){
        this.birthdate = birthDate;
    }

    /**
     * Вычисляем текущий возраст человека, если он из будущего возвращаем -1
     * @return возраст в годах
     */
    @Override
    public Integer getAge(){
        LocalDate now = LocalDate.now();
        if ((now.getYear() == birthdate.getYear() && now.getDayOfYear() < birthdate.getDayOfYear()) ||
                now.getYear() < birthdate.getYear()) return null;
        if (now.getMonthValue() > birthdate.getMonthValue())
            return now.getYear() - birthdate.getYear();
        if (now.getMonthValue() == birthdate.getMonthValue() && now.getDayOfMonth() >= birthdate.getDayOfMonth())
            return now.getYear() - birthdate.getYear();
        return now.getYear() - birthdate.getYear() - 1 >= 0 ? now.getYear() - birthdate.getYear() - 1 : 0;
    }

    /**
     * Возвращает devision
     * @return division
     */
    @Override
    public IDivision getDivision() {
        return division;
    }

    /**
     * Изменяет division
     * @param division division
     */
    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    /**
     * Получает salary
     * @return salary
     */
    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Изменяет salary
     * @param salary salary
     */
    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * Приведение класса к строке
     * @return класс в виде строки
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthdate +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }
}
