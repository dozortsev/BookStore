package com.dozortsev.bookstore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ClientBook")
public class ClientBook implements Serializable {

        @EmbeddedId
        private ClientBookId clientBookId = new ClientBookId();

        @Column(name = "IsBuy", nullable = false)
        private Boolean isBuy = false;


        public ClientBook() {
        }

        public ClientBook(Client client, Book book, Boolean isBuy) {
                this.isBuy = isBuy;

                setClient(client);
                setBook(book);
        }

        public ClientBookId getClientBookId() {
                return clientBookId;
        }
        public void setClientBookId(ClientBookId clientBookId) {
                this.clientBookId = clientBookId;
        }

        @Transient
        public Client getClient() {
                return getClientBookId().getClient();
        }
        public void setClient(Client client) {
                getClientBookId().setClient(client);
        }

        @Transient
        public Book getBook() {
                return getClientBookId().getBook();
        }
        public void setBook(Book book) {
                getClientBookId().setBook(book);
        }

        public Boolean getBuy() {
                return isBuy;
        }
        public void setBuy(Boolean buy) {
                isBuy = buy;
        }
}
