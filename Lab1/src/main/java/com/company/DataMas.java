package com.company;

import org.apache.commons.lang.ObjectUtils;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Массив который хранит объекты экземпляра Person.
 */
public class DataMas {
    /**
     * поле с экземплярами класса Person.
     */
    private Person[] arr;

    /**
     * Дефолтный размер массива.
     */
    private static final int DEFAULT_LENGTH = 1;

    /**
     * Последний добавленный индекс.
     */
    private int lastAddedIndex = -1;

    /**
     * Начальный конструктор.
     */
    public DataMas(){
        arr = new Person[DEFAULT_LENGTH];
    }

    /**
     * Создает массив указанной длины
     * @param ArrLength длина массива.
     */
    public DataMas(final int ArrLength){
        if(ArrLength > 0){
            arr = new Person[ArrLength];
        }
    }

    /**
     * Получает длину массива
     * @return arr length.
     */
    public int getLength(){
        return arr.length;
    }

    /**
     * Возвращает объект класса Person по индексу в массиве
     * @param index порядковый номер в массиве человека
     * @return Person.
     */
    public Person get(int index){
        if (index < arr.length && index >= 0){
            return arr[index];
        }
        return null;
    }

    /**
     * Метод добавляет person в массив
     * @param person добавляемый элемент.
     */
    public void add(final Person person){
        if (lastAddedIndex + 1 < arr.length) {
            arr[++lastAddedIndex] = person;
        }
        else{
            Person[] extendedArr = new Person[arr.length + DEFAULT_LENGTH];
            for (int i = 0; i < arr.length; i++){
                if (arr[i] != null) {
                    extendedArr[i] = arr[i];
                }
            }
            extendedArr[++lastAddedIndex] = person;
            arr = extendedArr;
        }
    }

    /**
     * Удаляет из массива элемент по индексу
     * @param index иднекс удаляемого элемента.
     */
    public void delete(final int index){
        if(index < arr.length && index >= 0){
            for(int i = index; i < lastAddedIndex; i++){
                arr[i] = arr[i + 1];
            }
            arr[lastAddedIndex--] = null;
        }
    }

    /**
     * Сортировка пузырьком по id по возрастанию.
     */
    public void sortById(){
        Person temp;
        for (int i=0; i<arr.length; i++){
            for (int j = arr.length-1; j > i; j--){
                if(arr[j-1].getId() > arr[j].getId()){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Сортировка простыми вставками по возрасту по возрастанию.
     */
    public void sortByBirthday(){
        for (int i=1; i<arr.length; i++){
            Person current = arr[i];
            int j = i - 1;
            while (j >= 0 && current.getAge() < arr[j].getAge()){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    /**
     * Быстрая сортировка по фамилии по возрастанию
     */
    public void sortBySurname(){
        for (int i=0; i<arr.length; i++){
            Person min = arr[i];
            int minId = i;
            for (int j=i+1; j<arr.length; j++){
                int m  = 0;
                while (arr[j].getSurname().substring(m, m + 1).equals(min.getSurname().substring(m, m + 1)) &&
                        m + 1 < arr[j].getSurname().length() && m + 1 < min.getSurname().length())
                    m++;
                if(arr[j].getSurname().charAt(m) < min.getSurname().charAt(m)){
                    min = arr[j];
                    minId = j;
                }
                m = 0;
            }
            Person temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;
        }
    }

    /**
     * Поиск по id
     * @param id идентификатор
     * @return объект класса Person
     */
    public Person search(int id){
        for (Person person : arr) {
            if (person.getId() == id)
                return person;
        }
        return null;
    }

    /**
     * Поиск по имени и фамилии
     * @param Name имя
     * @param Surname фамилия
     * @return список объектов класса Person с данным именем и фамилией
     */
    public ArrayList<Person> search(String Name, String Surname){
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person person : arr) {
            if (person.getSurname().equals(Surname) && person.getName().equals(Name))
                result.add(person);
        }
        return result;
    }
}
