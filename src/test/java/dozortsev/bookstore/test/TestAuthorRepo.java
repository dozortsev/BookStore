package dozortsev.bookstore.test;

import dozortsev.bookstore.model.Author;
import dozortsev.bookstore.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestAuthorRepo extends TestContext {

        @Test
        public void testLoadAuthor() {

                Author author = authorRepo.load(1);

                assertNotNull(author);
                assertNotNull(author.getBooks());
        }

        @Test
        public void testDeleteAuthor() {

                Integer id = 2;

                authorRepo.delete(authorRepo.load(id));

                assertNull(authorRepo.load(id));

                for (Book book : bookRepo.loadAll())
                        assertNotEquals(book.getAuthor().getId(), id);
        }
}
