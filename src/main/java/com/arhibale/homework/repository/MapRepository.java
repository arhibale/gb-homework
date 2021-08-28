package com.arhibale.homework.repository;

import java.util.List;

public interface MapRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void deleteById(Long id);

    void save (T t);
}