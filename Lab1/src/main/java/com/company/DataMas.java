package com.company;

public class DataMas {
    /**
     * поле с экземплярами класса Person
     */
    private Person[] arr;

    /**
     * Дефолтный размер массива
     */
    private static final int DEFAULT_LENGTH = 5;

    /**
     * Последний добавленный индекс
     */
    private int lastAddedIndex = -1;

    /**
     * Начальный конструктор
     */
    public DataMas(){
        arr = new Person[DEFAULT_LENGTH];
    }

    /**
     * Создает массив указанной длины
     * @param ArrLength длина массива
     */
    public DataMas(final int ArrLength){
        if(ArrLength > 0){
            arr = new Person[ArrLength];
        }
    }

    /**
     * Получает длину массива
     * @return arr length
     */
    public int GetLength(){
        return arr.length;
    }

    /**
     * Возвращает объект класса Person по индексу в массиве
     * @param index порядковый номер в массиве человека
     * @return Person
     */
    public Person Get(int index){
        if (index < arr.length && index >= 0){
            return arr[index];
        }
        return null;
    }

    /**
     * Метод добавляет person в массив
     * @param person добавляемый элемент
     */
    public void Add(Person person){
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
     * @param index иднекс удаляемого элемента
     */
    public void Delete(int index){
        if(index < arr.length && index >= 0){
            for(int i = index; i < lastAddedIndex; i++){
                arr[i] = arr[i + 1];
            }
            arr[lastAddedIndex--] = null;
        }
    }
}
