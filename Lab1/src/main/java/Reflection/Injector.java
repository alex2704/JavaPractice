package Reflection;

import Exeptions.ReflectException;
import annotations.LabInjector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class Injector {

    /**
     * Подключает сортировку по свойству из файла
     * @param repository репозиторий
     * @param <T> тип
     * @return репозиторий с инициализированным полем, у которого присутсвует аннотация
     */
    public static <T> T inject(T repository) throws ReflectException {
        try{
        List<List<String>> arr = getSort();
        for (Field field : repository.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(LabInjector.class) && arr != null){
                for (List<String> i: arr) {
                    if(field.getType().getName().equals(i.get(0))){
                        boolean isAccessible = field.canAccess(repository);
                        field.setAccessible(true);
                        field.set(repository, Class.forName(i.get(1)).newInstance());
                        field.setAccessible(isAccessible);
                    }
                }
            }
        }
        return repository;
        }
        catch (Exception e){
            new ReflectException(e.toString());
        }
        return null;
    }

    private static List<List<String>> getSort() {
        try {
            Properties properties = new Properties();
            FileInputStream stream = new FileInputStream("src/main/resources/sort.properties");
            properties.load(stream);
            Enumeration<?> en = properties.propertyNames();
            List<List<String>> content = new ArrayList<>();
            int i = 0;
            while(en.hasMoreElements()){
                String key = (String)en.nextElement();
                content.add(new ArrayList<String>());
                content.get(i).add(key);
                content.get(i).add(properties.getProperty(key));
                i++;
            }
            return content;
        }
        catch(Exception e){
            new ReflectException(e.toString());
        }
        return null;
    }

}
