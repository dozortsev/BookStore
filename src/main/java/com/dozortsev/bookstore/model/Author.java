package com.dozortsev.bookstore.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@javax.persistence.Entity
@Table(name = "Author")
public class Author extends Entity<Integer> {

        @Column(name = "Name", length = 100)
        private String name;

        @Column(name = "Surname", length = 100)
        private String surname;

        @OneToMany(fetch = LAZY, cascade = REMOVE, mappedBy = "author")
        private List<Book> books = new ArrayList<>();

        @Column(name = "DOB")
        @Temporal(DATE)
        private Date dob;


        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }

        public String getSurname() {
                return surname;
        }
        public void setSurname(String surname) {
                this.surname = surname;
        }

        public List<Book> getBooks() {
                return books;
        }
        public void setBooks(List<Book> books) {
                this.books = books;
        }

        public Date getDob() {
                return dob;
        }
        public void setDob(Date dob) {
                this.dob = dob;
        }
}
