package com.dozortsev.bookstore.data;


import com.dozortsev.bookstore.model.Entity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional(rollbackFor = Exception.class)

public class BaseRepoImpl<ID extends Serializable, T extends Entity<ID>> implements BaseRepo<ID, T> {

        protected T t;

        protected Class<T> clazz;

        protected HibernateTemplate hibernate;

        @Autowired
        private void setSessionFactory(SessionFactory factory) {
                hibernate = new HibernateTemplate(factory);
        }

        @Override public ID save(T model) {
                try {
                        hibernate.save(model);

                } catch (HibernateException e){

                }
                return model.getId();
        }

        @Override public T load(ID id) {
                try {
                        t = hibernate.get(clazz, id);

                } catch (HibernateException e){

                }
                return t;
        }

        @Override public void delete(T model) {
                try {
                        hibernate.delete(model);

                } catch (HibernateException e){

                }
        }

        @Override public void deleteById(ID id) {
                try {
                        hibernate.delete(load(id));
                } catch (HibernateException e) {

                }
        }

        @Override public T update(T model) {
                try {
                        t = hibernate.merge(model);

                } catch (HibernateException e) {

                }
                return t;
        }
}
