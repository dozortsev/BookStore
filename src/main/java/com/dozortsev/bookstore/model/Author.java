package com.dozortsev.bookstore.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;
import static org.hibernate.annotations.CascadeType.DELETE;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Table(name = "Author")
public class Author extends AbstractEntity<Integer> {

        @Column(name = "Name", length = 100)
        private String name;

        @Column(name = "Surname", length = 100)
        private String surname;

        @OneToMany(fetch = EAGER, mappedBy = "author") @Cascade({ SAVE_UPDATE, DELETE })
        private List<Book> books = new ArrayList<>();

        @Column(name = "DOB")
        @Temporal(DATE)
        private Calendar dob;


        public Author() {
        }

        public Author(String name, String surname, Calendar dob) {
                this.name = name;
                this.surname = surname;
                this.dob = dob;
        }

        public Author(String name, String surname, List<Book> books, Calendar dob) {
                this.name = name;
                this.surname = surname;
                this.books = books;
                this.dob = dob;
        }

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

        public Calendar getDob() {
                return dob;
        }
        public void setDob(Calendar dob) {
                this.dob = dob;
        }
}
