package com.gear.proex.service.impl;

import com.gear.proex.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class GenericServiceImpl<T,I> implements GenericService<T, I> {

    @Autowired
    protected JpaRepository<T,I> repository;

    @Override
    public List<T> getAll(){
        return repository.findAll();
    }

    @Override
    public Page<T> getAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<T> getAllPaginated(Example example, Pageable pageable) {
        return repository.findAll(example,pageable);
    }

    @Transactional
    @Override
    public T saveOrUpdate(T entity) {
        try{
            return repository.save(entity);
        } catch (Exception e){
            throw e;

        }
    }

    @Override
    public T get(I id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public T add(T entity) {
        try {
            return repository.save(entity);
        } catch (Exception e){
            throw e;
        }
    }

    @Transactional
    @Override
    public T update(T entity) {
        try {
            return repository.save(entity);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void remove(T entity) {
        try{
            repository.delete(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void removeById(I id) {
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
