package com.dozortsev.bookstore.test;

import com.dozortsev.bookstore.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestBookRepo extends TestContext {

    @Test public void testLoadBook() {

        final Integer id = 1;

        Book book = bookRepo.load(id);

        assertNotNull(book);
        assertNotNull(book.getAuthor());
    }

    @Test public void testGetBook() {

        final Integer id = 1;

        Book book = bookRepo.get(bookRepo.loadAll(), id);

        assertNotNull(book);
        assertNotNull(book.getAuthor());

        Book expBook = bookRepo.load(id);
        assertEquals(expBook, book);
        assertEquals(expBook.getAuthor(), book.getAuthor());
    }

    @Test public void testDeleteBook() {

        final Integer idBook = 7;

        Book book = bookRepo.load(idBook);
        assertNotNull(book);
        assertNotNull(book.getAuthor());

        final Integer idAuthor = book.getAuthor().getId();

        bookRepo.delete(book);
        assertNull(bookRepo.load(idBook));

        assertNotNull(authorRepo.load(idAuthor));
    }
}
