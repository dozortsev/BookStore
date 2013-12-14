package com.dozortsev.bookstore.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "Book")
public class Book extends AbstractEntity<Integer> {

    @Column(name = "Name", length = 255, nullable = false)
    private String name;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "Author", nullable = false)
    private Author author;

    @Column(name = "Genre", length = 100)
    private String genre;

    @Column(name = "Language", length = 100)
    private String language;

    @Column(name = "PubDate")
    @Temporal(DATE)
    private Date pubDate;

    @Column(name = "Pages")
    private Integer pages;

    @Column(name = "Price", precision = 4, scale = 2)
    private Double price;

    @Lob @Column(name = "Description")
    private String description;


    public Book() {
    }

    public Book(String name, Author author, String genre, String language,
                Date pubDate, Integer pages, Double price, String description) {

        this.name = name;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.pubDate = pubDate;
        this.pages = pages;
        this.price = price;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!genre.equals(book.genre)) return false;
        if (!language.equals(book.language)) return false;
        if (!name.equals(book.name)) return false;
        if (!pages.equals(book.pages)) return false;
        if (!price.equals(book.price)) return false;
        if (!pubDate.equals(book.pubDate)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + pubDate.hashCode();
        result = 31 * result + pages.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}

