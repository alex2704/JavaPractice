package repository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T> {
    void add(T var1);

    T get(int var1);

    T delete(int var1);

    T set(int var1, T var2);

    void add(int var1, T var2);

    List<T> toList();

    void sortBy(Comparator<T> var1);

    IRepository<T> searchBy(Predicate<T> var1);
}
