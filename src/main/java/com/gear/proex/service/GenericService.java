package com.gear.proex.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T,I> {

    List<T> getAll();

    Page<T> getAllPaginated(Pageable pageable);

    Page<T> getAllPaginated(Example example, Pageable pageable);

    T saveOrUpdate(T entity);

    T get(I id);

    T add(T entity);

    T update(T entity);

    void remove(T entity);

    void removeById(I id);

}
