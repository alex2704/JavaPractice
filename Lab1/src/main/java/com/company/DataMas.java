package com.company;

import ru.vsu.lab.repository.IRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Массив который хранит объекты
 */
public class DataMas<T> implements IRepository<T>{
    /**
     * поле с экземплярами класса Person.
     */
    private Object [] arr;

    /**
     * Дефолтный размер массива.
     */
    private static final int DEFAULT_LENGTH = 5;

    /**
     * Множитель расширения массива
     */
    private static final double INCREASE_FACTOR = 1.5;

    /**
     * Последний добавленный индекс.
     */
    private int lastAddedIndex = -1;

    /**
     * Начальный конструктор.
     */
    public DataMas(){
        arr = new Object[DEFAULT_LENGTH];
    }

    /**
     * Создает массив указанной длины
     * @param ArrLength длина массива.
     */
    public DataMas(final int ArrLength){
        if(ArrLength > 0){
            arr = new Object[ArrLength];
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
     * приведение к списку.
     */
    @Override
    public List<T> toList() {
        return Arrays.asList((T[])arr);
    }

    /**
     * Возвращает объект класса Person по индексу в массиве
     * @param index порядковый номер в массиве человека
     * @return Person.
     */
    @Override
    public T get(int index){
        if (index < arr.length && index >= 0){
            return getT(index);
        }
        return null;
    }

    /**
     * изменяем элемент массива на позиции index.
     */
    @Override
     public T set(int index, T person) {
        if (index < arr.length && index >= 0) {
            T temp = getT(index);
            arr[index] = person;
            return temp;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private T getT(int index){
        return (T)this.arr[index];
    }

    /**
     * Метод добавляет person в массив
     * @param person добавляемый элемент.
     */
    @Override
    public void add(T person){
        if (lastAddedIndex + 1 < arr.length) {
            arr[++lastAddedIndex] = person;
        }
        else{
            Object[] extendedArr = new Object[arr.length + (int)(arr.length * INCREASE_FACTOR)];
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
     * Метод добавляет Person в массив на определенную позицию
     * @param index position
     * @param person person object
     */
    @Override
    public void add(int index, T person) {
        if (index + 1 < arr.length && arr[arr.length - 1] == null) {
            if (arr[index] != null) {
                right_shift_mas(index, person, arr);
            } else {
                arr[index] = person;
            }
        }
        else{
            int length = 0;
            while (length < index){
                length +=arr.length + (int)(arr.length * INCREASE_FACTOR);
            }
            Object[] extendedArr = new Object[arr.length + (int)(arr.length * INCREASE_FACTOR)];
            if (index >= 0) System.arraycopy(arr, 0, extendedArr, 0, index);
            right_shift_mas(index, person, extendedArr);
            arr = extendedArr;
        }
        if(index > lastAddedIndex)
            lastAddedIndex = index;
        else
            lastAddedIndex++;
    }

    /**
     * Сдвигает элементы в массиве на 1 вправо и вставляет вместо сдвига элемент
     * @param index index с которого начинается сдвиг
     * @param person person элемент
     * @param arr массив с которым работаем
     */
    private void right_shift_mas(int index, T person, Object[] arr) {
        Object tmp = arr[index];
        arr[index] = person;

        for (int i = index +1 ; i < arr.length; i++) {
            Object next = arr[i];
            arr[i] = tmp;
            tmp = next;
        }
    }

    /**
     * Удаляет из массива элемент по индексу
     * @param index иднекс удаляемого элемента.
     */
    @Override
    public T delete(final int index){
        if(index < arr.length && index >= 0){
            T n = this.get(index);
            for(int i = index; i < lastAddedIndex; i++){
                arr[i] = arr[i + 1];
            }
            arr[lastAddedIndex--] = null;
            return n;
        }
        return null;
    }

    /**
     * Сортировка пузырьком по id по возрастанию
     * @param comparator comparator Object
     */
    public void bubbleSortBy(Comparator<T> comparator ){
        T temp;
        for (int i=0; i<lastAddedIndex + 1; i++){
            for (int j = lastAddedIndex; j > i; j--){
                if(comparator.compare(getT(j-1), getT(j)) > 0){
                    temp = getT(j-1);
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Сортировка простыми вставками по возрасту по возрастанию.
     * @param comparator
     */
    @Override
    public void sortBy(Comparator comparator ){
        for (int i=1; i < lastAddedIndex + 1; i++){
            T current = getT(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(current, getT(j)) < 0){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

//    /**
//     * Быстрая сортировка по фамилии по возрастанию
//     */
//    public void sortBySurname(){
//        for (int i=0; i<lastAddedIndex + 1; i++){
//            Person min = (Person) arr[i];
//            int minId = i;
//            for (int j=i+1; j<lastAddedIndex + 1; j++){
//                int m  = 0;
//                while (arr[j].getLastName().substring(m, m + 1).equals(min.getLastName().substring(m, m + 1)) &&
//                        m + 1 < arr[j].getLastName().length() && m + 1 < min.getLastName().length())
//                    m++;
//                if(arr[j].getLastName().charAt(m) < min.getLastName().charAt(m)){
//                    min = (Person) arr[j];
//                    minId = j;
//                }
//                m = 0;
//            }
//            Person temp = (Person) arr[i];
//            arr[i] = min;
//            arr[minId] = temp;
//        }
//    }

//    /**
//     * Поиск по имени и фамилии
//     * @param Name имя
//     * @param Surname фамилия
//     * @return список объектов класса Person с данным именем и фамилией
//     */
//    public DataMas search(String Name, String Surname) throws Exception{
//        DataMas result = new DataMas();
//        for (IPerson person : arr) {
//            if (person.getLastName().equals(Surname) && person.getFirstName().equals(Name))
//                result.add(person);
//        }
//        throw new Exception("Объекта с соответсвующими параметрами не найдено");
//    }

    /**
     * Поиск по массиву с задданым условием
     * @param condition predicate
     * @return repository mas
     */
    @Override
    public IRepository<T> searchBy(Predicate condition) {
        DataMas<T> repository = new DataMas<T>();
        for (int i = 0; i < lastAddedIndex + 1; i++) {
            if(arr[i] != null){
                if (condition.test(getT(i))) {
                    repository.add(getT(i));
                }
            }
        }
        return repository;
    }
}
