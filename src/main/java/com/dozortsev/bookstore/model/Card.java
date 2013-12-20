package com.dozortsev.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "Card")
public class Card extends AbstractEntity<Integer> {

    @Embedded
    private final CardId idCard = new CardId();

    @Column(name = "Status", nullable = false)
    private Boolean status;


    public Card() {
    }

    public Card(Client client, Book book, Boolean status) {
        this.status = status;

        setClient(client);
        setBook(book);
    }

    @Transient
    public Client getClient() {
        return idCard.getClient();
    }

    public void setClient(Client client) {
        idCard.setClient(client);
    }

    @Transient
    public Book getBook() {
        return idCard.getBook();
    }

    public void setBook(Book book) {
        idCard.setBook(book);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!idCard.equals(card.idCard)) return false;
        if (!status.equals(card.status)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = idCard.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
