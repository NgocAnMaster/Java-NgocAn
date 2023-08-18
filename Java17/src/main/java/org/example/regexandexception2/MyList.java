package org.example.regexandexception2;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    List<T> list = new ArrayList<>();

    public void add(T t){
        list.add(t);
    }

    public T remove(int index){
        T remove = list.remove(index);
        return remove;
    }
}
