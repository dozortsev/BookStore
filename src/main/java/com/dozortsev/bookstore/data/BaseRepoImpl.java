package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.AbstractEntity;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import static org.apache.log4j.Logger.getLogger;

@Repository
@Transactional(rollbackFor = Exception.class)

public class BaseRepoImpl<ID extends Serializable, T extends AbstractEntity<ID>> implements BaseRepo<ID, T> {

        private T t;

        private Class<T> clazz;

        private SessionFactory factory;

        private static final Logger log = getLogger(BaseRepoImpl.class);

        @Autowired
        public void setFactory(SessionFactory factory) {
                this.factory = factory;
        }

        @Override public ID save(T t) {
                try {
                        factory.getCurrentSession().save(t);

                } catch (HibernateException e) {
                        e.printStackTrace();
                }
                return t.getId();
        }

        @SuppressWarnings("unchecked")
        @Override public T load(ID id) {
                try {
                        t = (T) factory.getCurrentSession().get(getEntityClass(), id);

                } catch (HibernateException e) {
                        e.printStackTrace();
                }
                return t;
        }

        @Override public void delete(T t) {
                try {
                        factory.getCurrentSession().delete(t);

                } catch (HibernateException e){
                        e.printStackTrace();
                }
        }

        @Override public void deleteById(ID id) {
                try {
                        delete(load(id));

                } catch (HibernateException e) {
                        e.printStackTrace();
                }
        }

        @Override public T update(T t) {
                try {
                        factory.getCurrentSession().update(t);

                } catch (HibernateException e) {
                        e.printStackTrace();
                }
                return t;
        }

        public Class<T> getEntityClass() {
                return clazz;
        }
        public void setEntityClass(Class<T> clazz) {
                this.clazz = clazz;
        }
}
