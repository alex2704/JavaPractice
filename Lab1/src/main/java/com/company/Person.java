package com.company;

import enums.Gender;
import interfaces.IDivision;
import interfaces.IPerson;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

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
    private LocalDate birthDate;

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
     * @param birthDate дата рождения
     * @param salary зарплата
     * @param division классификация
     */
    public Person(Integer id, String firstName, String lastName, Gender gender, LocalDate birthDate, BigDecimal salary,
                  IDivision division){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
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
        return birthDate;
    }

    /**
     * @param birthDate дата рождения
     */
    @Override
    public void setBirthdate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Вычисляем текущий возраст человека, если он из будущего возвращаем -1
     * @return возраст в годах
     */
    @Override
    public Integer getAge() throws Exception{
        LocalDate now = LocalDate.now();
        if ((now.getYear() == birthDate.getYear() && now.getDayOfYear() < birthDate.getDayOfYear()) ||
                now.getYear() < birthDate.getYear()) throw new Exception("Введенная дата из будущего");
        if (now.getMonthOfYear() > birthDate.getMonthOfYear())
            return now.getYear() - birthDate.getYear();
        if (now.getMonthOfYear() == birthDate.getMonthOfYear() && now.getDayOfMonth() >= birthDate.getDayOfMonth())
            return now.getYear() - birthDate.getYear();
        return now.getYear() - birthDate.getYear() - 1 >= 0 ? now.getYear() - birthDate.getYear() - 1 : 0;
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
                ", birthDate=" + birthDate +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }
}
