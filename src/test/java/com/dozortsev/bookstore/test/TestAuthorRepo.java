package com.dozortsev.bookstore.test;

import com.dozortsev.bookstore.model.Author;
import com.dozortsev.bookstore.model.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAuthorRepo extends TestContext {

    @Test public void testDeleteAuthor() throws Exception {

        Integer id = 2;

        Author author = authorRepo.load(id);
        assertNotNull(author);

        authorRepo.delete(author);
        assertNull(authorRepo.load(id));

        for (Book book : bookRepo.loadAll())
            assertNotEquals(id, book.getAuthor().getId());
    }
}
