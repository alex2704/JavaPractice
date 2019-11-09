package com.company;

import org.joda.time.LocalDate;

public class Person {
    /**
     * поле идентификатор
     */
    private int id;

    /**
     * имя
     */
    private String name;

    /**
     * фамилия
     */
    private String surname;

    /**
     * отчество
     */
    private String patronymic;

    /**
     * пол
     */
    private String gender;

    /**
     * дата дня рождения человека
     */
    private LocalDate birthDay;

    /**
     *
     * @param id идентификатор
     * @param name имя
     * @param surname фамилия
     * @param patronymic отчество
     * @param gender пол
     * @param birthDay дата рождения
     */
    public Person(int id, String name, String surname, String patronymic, String gender, LocalDate birthDay){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    /**
     * @return  идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return  пол
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender пол
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return  отчество
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * @param patronymic отчество
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * @return фамилия
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname фамилия
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return дата рождения
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }

    /**
     * @param birthDay дата рождения
     */
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * Вычисляем текущий возраст человека, если он из будущего возвращаем -1
     * @return возраст в годах
     */
    public int getAge(){
        LocalDate now = LocalDate.now();
        if ((now.getYear() == birthDay.getYear() && now.getDayOfYear() < birthDay.getDayOfYear()) ||
                now.getYear() < birthDay.getYear()) return -1;
        if (now.getMonthOfYear() > birthDay.getMonthOfYear())
            return now.getYear() - birthDay.getYear();
        if (now.getMonthOfYear() == birthDay.getMonthOfYear() && now.getDayOfMonth() >= birthDay.getDayOfMonth())
            return now.getYear() - birthDay.getYear();
        return now.getYear() - birthDay.getYear() - 1 >= 0 ? now.getYear() - birthDay.getYear() - 1 : 0;
    }

    /**
     * Приведение класса к строке
     * @return класс в виде строки
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
