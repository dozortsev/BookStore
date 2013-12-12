package com.dozortsev.bookstore.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Embeddable
public class CardId implements Serializable {

    @ManyToOne @Cascade(SAVE_UPDATE)
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardId that = (CardId) o;

        if (!book.equals(that.book)) return false;
        if (!client.equals(that.client)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + book.hashCode();
        return result;
    }
}
