package com.dozortsev.bookstore.model;

import javax.persistence.*;

import java.util.HashMap;
import java.util.Map;

@javax.persistence.Entity
@Table(name = "Client")
public class Client extends Entity<Integer> {

        @Column(name = "Name", length = 100)
        private String name;

        @Column(name = "Surname", length = 100)
        private String surname;

        @Column(name = "Password", length = 15, unique = true, nullable = false)
        private String password;

        @Column(name = "Email", length = 200, unique = true, nullable = false)
        private String email;

        @ElementCollection
        @CollectionTable(
                name = "ClientToBooks",
                joinColumns = {
                        @JoinColumn(name = "idClient"),
                        @JoinColumn(name = "idBook")
        })
        @AttributeOverrides({
                @AttributeOverride(name = "key.Book", column = @Column(name="Book")),
                @AttributeOverride(name = "value.isBuy", column = @Column(name="isBuy"))
        })
        private Map<Book, Boolean> bookMap = new HashMap<>();


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

        public String getPassword() {
                return password;
        }
        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }
}
