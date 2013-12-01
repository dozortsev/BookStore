package dozortsev.bookstore.test;

import dozortsev.bookstore.model.Book;
import dozortsev.bookstore.model.Client;
import dozortsev.bookstore.model.ClientBook;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static dozortsev.bookstore.util.Util.getRandPassword;
import static org.junit.Assert.*;

public class TestClientRepo extends TestContext {
        
        @Ignore
        public void testSaveClient() {

                Integer[] arrBookId = { 1, 3 };

                final String name = "Martin", surname = "Fowler",
                        pwd = getRandPassword(), email = "fowler@gmail.com";

                Client client = new Client(name, surname, pwd, email);

                List<ClientBook> books = new ArrayList<>();
                books.add(new ClientBook(client, bookRepo.load(arrBookId[0]), false));
                books.add(new ClientBook(client, bookRepo.load(arrBookId[1]), true));

                client.setBooks(books);

                assertNull(client.getId());
                clientRepo.save(client);
                assertNotNull(client.getId());

                client = clientRepo.load(client.getId());

                assertEquals(name, client.getName());
                assertEquals(surname, client.getSurname());
                assertEquals(email, client.getEmail());
                assertEquals(pwd, client.getPassword());

                for (int i = 0; i < arrBookId.length; i++)
                        assertEquals(arrBookId[i], client.getBooks().get(i).getBook().getId());
        }

        @Ignore
        public void testDeleteClient() {

             Integer idClient = 1;

             clientRepo.delete(clientRepo.load(idClient));

             assertNull(clientRepo.load(idClient));
        }

        @Ignore
        public void testUpdateClient() {

                Integer idClient = 2, idBook = 8;

                Book book = bookRepo.load(idBook);
                Client client = clientRepo.load(idClient);
                ClientBook cb = new ClientBook(client, book, true);

                client.getBooks().add(cb);

                client = clientRepo.update(client);

                Integer index = client.getBooks().size() - 1;

                assertEquals(idBook, client.getBooks().get(index).getBook().getId());
        }

        @Ignore
        public void testAuthentication() {

                String email, pwd;

                for (Client client : clientRepo.loadAll()) {

                        email = client.getEmail();
                        pwd = client.getPassword();

                        Client expectedClient = clientRepo.authentication(email, pwd);

                        assertEquals(expectedClient.getId(), client.getId());
                }
        }

        @Ignore
        public void testLoadNotClientBooks() throws Exception {

                Client client = clientRepo.load(2);
                assertNotNull(client);

                Set<Book> books = bookRepo.loadAll();
                assertNotNull(books);
                assertNotEquals(books.size(), 0);

                List<ClientBook> clientBooks = client.getBooks();
                assertNotNull(clientBooks);
                assertNotEquals(clientBooks.size(), 0);

                for (ClientBook clientBook : clientBooks)
                        assertTrue(books.remove(clientBook.getBook()));
        }

        @Test
        public void testLoadAllBook() throws Exception {

                Set<Book> books = bookRepo.loadAll();
                int size = books.size();

                for (ClientBook cb : clientRepo.load(2).getBooks()) {

                        books.remove(cb.getBook());
                }

                assertNotEquals(size, books.size());
        }
}

