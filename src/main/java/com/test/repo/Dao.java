/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.repo;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Cris John Alonzaga
 * @param <T>
 */
public interface Dao<T> {

    public List<T> getAll();
    
    public Optional<T> get(long id);

    public void save(T t);

    public void update(T t, String param);

    public void delete(T t);

    public void save(List<T> t);

}
