package com.company;
import annotations.LabInjector;
import org.apache.log4j.Logger;
import ru.vsu.lab.repository.IRepository;
import sorts.ISorter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Массив который хранит объекты
 */
@XmlRootElement(name = "repo")
@XmlSeeAlso({Person.class})
public class DataMas<T> implements IRepository<T>{
    private static Logger logger = Logger.getLogger(DataMas.class);

    @LabInjector
    private ISorter<T> sort;

    /**
     * поле с экземплярами класса Person.
     */
    @XmlElementWrapper(name = "personsList")
    @XmlElement(name = "person")
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
        logger.debug("Created DataMas with length" + ArrLength);
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
        logger.debug("set new item with index " + index + "and object " + person.toString());
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
        logger.debug("adding new person " + person.toString());
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
        logger.debug("adding new person " + person.toString() + "and index " + index);
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
        logger.debug("right_shift_mas params: " + person.toString() + "and index " + index + "arr length" + arr.length);
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
        logger.debug("deleting item with index " + index);
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
     * Отсортировать массив
     *
     * @param comparator
     * @param sort
     */
    @SuppressWarnings("unchecked")
    private void sortBy(Comparator<T> comparator, ISorter sort) {
        sort.sort(arr, comparator);
    }

    /**
     * Сортировка простыми вставками по возрасту по возрастанию.
     * @param comparator
     */
    @Override
    public void sortBy(Comparator<T> comparator){
        sortBy(comparator, sort);
    }

    /**
     * Поиск по массиву с задданым условием
     * @param condition predicate
     * @return repository mas
     */
    @Override
    public IRepository<T> searchBy(Predicate<T> condition) {
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
