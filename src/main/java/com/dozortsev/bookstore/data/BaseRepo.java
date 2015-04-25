package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.AbstractEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface BaseRepo<ID extends Serializable, T extends AbstractEntity<ID>> {

    ID save(T model);

    T load(ID id);

    T get(Collection<T> c, ID id);

    void delete(T model);

    @SuppressWarnings("unused")
    void deleteById(ID id);

    T update(T model);

    Set<T> loadAll();
}
