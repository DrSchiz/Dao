package com.example.testproj2.dao;

import java.util.List;

public interface DaoInterface<T> {
    void save(T cl);
    void update(T cl);
    void delete(T cl, int Id);
    T show(int Id);
}
