package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.AbstractEntity;

import java.io.Serializable;
import java.util.Set;

public interface BaseRepo<ID extends Serializable, T extends AbstractEntity<ID>> {

    public ID save(T model);

    public T load(ID id);

    public void delete(T model);

    @SuppressWarnings("unused")
    public void deleteById(ID id);

    public T update(T model);

    public Set<T> loadAll();
}
