package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Entity;

import java.io.Serializable;

public interface BaseRepo<ID extends Serializable, T extends Entity<ID>> {

        public ID save(T model);

        public T load(ID id);

        public void delete(T model);

        public void deleteById(ID id);

        public T update(T model);
}
