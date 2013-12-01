package dozortsev.bookstore.test;

import dozortsev.bookstore.model.Book;

import org.hibernate.AssertionFailure;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestBookRepo extends TestContext {

        @Test
        public void testLoadBook() {

                Book book = bookRepo.load(1);

                assertNotNull(book);
                assertNotNull(book.getAuthor());
        }

        @Test(expected = AssertionFailure.class)
        public void testSaveBook() {

                Book book = new Book();
                book.setName("Thinking in Java 4th");
                book.setAuthor(null);

                bookRepo.save(book);
        }

        @Test
        public void testDeleteBook() {

                Integer idBook = 7, idAuthor;

                Book book = bookRepo.load(idBook);

                idAuthor = book.getAuthor().getId();

                bookRepo.delete(book);
                assertNull(bookRepo.load(idBook));

                assertNotNull(authorRepo.load(idAuthor));
        }
}
