package com.dozortsev.bookstore.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.TemporalType.TIMESTAMP;
import static org.hibernate.annotations.CascadeType.DELETE;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity @Table(name = "Client")
public class Client extends AbstractEntity<Integer> {

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "Surname", length = 100, nullable = false)
    private String surname;

    @Column(name = "Joined", updatable = false, nullable = false)
    @Temporal(TIMESTAMP)
    private Date joined;

    @Column(name = "Address", length = 200)
    private String address;

    @Column(name = "Phone", length = 10)
    private String phone;

    @Column(name = "Email", length = 200, unique = true, nullable = false)
    private String email;

    @Column(name = "Password", length = 15, unique = true, nullable = false)
    private String password;

    @OneToMany(fetch = EAGER, mappedBy = "idCard.client")
    @Cascade({ SAVE_UPDATE, DELETE })
    private Set<Card> cards = new LinkedHashSet<>();


    public Client() {
        joined = new Date();
    }

    public Client(String name, String surname, String phone, String address, String email, String password) {
        this.name = name;
        this.surname = surname;
        joined = new Date();
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public Date getJoined() {
        return joined;
    }
    @SuppressWarnings("unused")
    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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

    public Set<Card> getCards() {
        return cards;
    }
    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }


    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!email.equals(client.email)) return false;
        if (!name.equals(client.name)) return false;
        if (!password.equals(client.password)) return false;
        if (!surname.equals(client.surname)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
