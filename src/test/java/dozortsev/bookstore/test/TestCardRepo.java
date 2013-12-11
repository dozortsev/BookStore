package dozortsev.bookstore.test;

import dozortsev.bookstore.model.Book;
import dozortsev.bookstore.model.Card;
import dozortsev.bookstore.model.Client;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class TestCardRepo extends TestContext {

    @Test public void testSaveCard() throws Exception {

        Integer idClient = 7, idBook = 3;

        Card card = new Card();
        card.setBook(bookRepo.load(idBook));
        card.setClient(clientRepo.load(idClient));
        card.setStatus(false);

        assertNull(card.getId());
        cardRepo.save(card);
        assertNotNull(card.getId());

        Client client = clientRepo.load(idClient);
        assertNotNull(client);
        assertNotNull(client.getCards());
        assertTrue(client.getCards().contains(card));
    }

    @Test public void testLoadCard() throws Exception {

        Integer idCard = 4;

        Card card = cardRepo.load(idCard);
        assertNotNull(card);
        assertNotNull(card.getBook());
        assertNotNull(card.getClient());

        Book book = bookRepo.load(card.getBook().getId());
        assertEquals(book, card.getBook());

        Client client = clientRepo.load(card.getClient().getId());
        assertEquals(client, card.getClient());
    }

    @Test public void testDeleteCard() throws Exception {

        Integer idCard = 17, idClient;

        Card card = cardRepo.load(idCard);
        assertNotNull(card);
        assertNotNull(card.getBook());
        assertNotNull(card.getClient());

        idClient = card.getClient().getId();

        cardRepo.delete(card);

        assertNull(cardRepo.load(idCard));

        Client client = clientRepo.load(idClient);
        assertNotNull(client);
        assertFalse(client.getCards().contains(card));
    }

    @Test public void testRemoveAll() throws Exception {

        Set<Book> books = bookRepo.loadAll();
        assertNotNull(books);
        assertNotEquals(0, books.size());

        Client client = clientRepo.load(3);
        assertNotNull(client);
        assertNotNull(client.getCards());
        assertNotEquals(0, client.getCards().size());

        for (Card card : client.getCards())
            assertTrue(books.remove(card.getBook()));
    }
}
