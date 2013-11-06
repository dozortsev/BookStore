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
                        log.info("Saving new " + getEntityName() + ".");
                        factory.getCurrentSession().save(t);
                        log.info("Successful saved.");

                } catch (HibernateException e) {
                        log.error("Error:", e);
                }
                return t.getId();
        }

        @SuppressWarnings("unchecked")
        @Override public T load(ID id) {
                try {
                        log.info("Loading " + getEntityName() + " by Id: " + id + ".");
                        t = (T) factory.getCurrentSession().get(getEntityClass(), id);
                        log.info("Successful loaded.");

                } catch (HibernateException e) {
                        log.error("Error:", e);
                }
                return t;
        }

        @Override public void delete(T t) {
                try {
                        log.info("Deleting " + getEntityName() + ".");
                        factory.getCurrentSession().delete(t);
                        log.info("Successful deleted.");

                } catch (HibernateException e){
                        log.error("Error:", e);
                }
        }

        @Override public void deleteById(ID id) {
                try {
                        delete(load(id));

                } catch (HibernateException e) {
                        log.error("Error:", e);
                }
        }

        @Override public T update(T t) {
                try {
                        log.info("Updating " + getEntityName() + ".");
                        factory.getCurrentSession().update(t);
                        log.info("Successful updated.");

                } catch (HibernateException e) {
                        log.error("Error:", e);
                }
                return t;
        }

        public Class<T> getEntityClass() {
                return clazz;
        }
        public void setEntityClass(Class<T> clazz) {
                this.clazz = clazz;
        }

        private String getEntityName() {
                return getEntityClass().getSimpleName();
        }
}
