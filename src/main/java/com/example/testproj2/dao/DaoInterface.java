package com.example.testproj2.dao;

import java.util.List;

public interface DaoInterface<T> {
    void save(Object tClass);
    void update(Object tClass, int Id);
    void delete(Object tClass, int Id);
    List<T> index(Object tClass);
    T show(DaoClass.classes classes, int Id);
}
