package com.dozortsev.bookstore.test;

import com.dozortsev.bookstore.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestBookRepo extends TestContext {

    @Test public void testLoadBook() throws Exception {

        Book book = bookRepo.load(1);

        assertNotNull(book);
        assertNotNull(book.getAuthor());
    }

    @Test public void testDeleteBook() throws Exception {

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
