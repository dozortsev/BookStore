package com.dozortsev.bookstore.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "BookToClient")
public class BookToClient {

        @Id @GeneratedValue(strategy = IDENTITY)
        @Column(name = "Id")
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "IdBook", nullable = false)
        private Book idBook;

        @ManyToOne
        @JoinColumn(name = "IdClient", nullable = false)
        private Client idClient;

        @Column(name = "IsBuy")
        private Boolean isBuy;


}
