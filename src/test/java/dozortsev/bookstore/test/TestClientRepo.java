package dozortsev.bookstore.test;

import dozortsev.bookstore.model.Card;
import dozortsev.bookstore.model.Client;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TestClientRepo extends TestContext {

    @Test public void testSaveClient() throws Exception {

        String name = "Martin", surname = "Fowler",
                pwd = "7777mario", email = "fowler@gmail.com";

        Client client = new Client(name, surname, email, pwd);

        Set<Card> cards = new LinkedHashSet<>();
        Card card1 = new Card(client, bookRepo.load(1), false);
        cards.add(card1);

        Card card2 = new Card(client, bookRepo.load(3), true);
        cards.add(card2);

        client.setCards(cards);

        assertNull(client.getId());
        clientRepo.save(client);
        assertNotNull(client.getId());

        client = clientRepo.load(client.getId());

        assertEquals(name, client.getName());
        assertEquals(surname, client.getSurname());
        assertEquals(email, client.getEmail());
        assertEquals(pwd, client.getPassword());

        assertTrue(client.getCards().contains(card1));
        assertTrue(client.getCards().contains(card2));
    }

    @Test public void testDeleteClient() throws Exception {

        Integer id = 1;

        clientRepo.delete(clientRepo.load(id));

        assertNull(clientRepo.load(id));

        for (Card card : cardRepo.loadAll())
            assertNotEquals(id, card.getClient().getId());
    }

    @Test public void testUpdateClient() throws Exception {

        Integer idClient = 2, idBook = 8;

        Client client = clientRepo.load(idClient);
        assertNotNull(client);

        Card card = new Card(client, bookRepo.load(idBook), true);
        client.getCards().add(card);

        client = clientRepo.update(client);
        assertTrue(client.getCards().contains(card));

        client = clientRepo.load(idClient);
        assertTrue(client.getCards().contains(card));
    }

    @Test public void testLoadAllCards() throws Exception {

        Integer id = 3;

        Client client = clientRepo.load(id);

        for (Card card : client.getCards())
            assertEquals(id, card.getClient().getId());
    }

    @Test public void testAuthentication() throws Exception {

        for (Client client : clientRepo.loadAll()) {

            String email = client.getEmail(), pwd = client.getPassword();

            Client expectedClient = clientRepo.authentication(email, pwd);

            assertTrue(expectedClient.equals(client));
        }
    }
}

