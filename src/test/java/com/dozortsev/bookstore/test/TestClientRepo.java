package com.dozortsev.bookstore.test;

import com.dozortsev.bookstore.model.Card;
import com.dozortsev.bookstore.model.Client;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TestClientRepo extends TestContext {

    final String NAME = "Martin",
            SURNAME = "Fowler",
            PHONE = "0887543534",
            ADDRESS = "San Francisco, USA",
            PASSWORD = "7777Fowler",
            EMAIL = "fowler@gmail.com";

    @Test public void testSaveClient() {

        final Client client = new Client(NAME, SURNAME, PHONE, ADDRESS, EMAIL, PASSWORD);

        Set<Card> cards = new LinkedHashSet<>();
        Card card1 = new Card(client, bookRepo.load(1), false);
        cards.add(card1);

        Card card2 = new Card(client, bookRepo.load(3), true);
        cards.add(card2);

        client.setCards(cards);

        assertNull(client.getId());
        clientRepo.save(client);
        assertNotNull(client.getId());

        Client expClient = clientRepo.load(client.getId());

        assertEquals(NAME, expClient.getName());
        assertEquals(SURNAME, expClient.getSurname());
        assertEquals(PHONE, expClient.getPhone());
        assertEquals(EMAIL, expClient.getEmail());
        assertEquals(PASSWORD, expClient.getPassword());

        assertTrue(client.getCards().contains(card1));
        assertTrue(client.getCards().contains(card2));
    }

    @Test public void testDeleteClient() {

        final Integer id = 1;

        clientRepo.delete(clientRepo.load(id));

        assertNull(clientRepo.load(id));

        for (Card card : cardRepo.loadAll())
            assertNotEquals(id, card.getClient().getId());
    }

    @Test public void testUpdateClient() {

        final Integer idClient = 2, idBook = 8;

        final Client client = clientRepo.load(idClient);
        assertNotNull(client);
        final Date joined = client.getJoined();
        assertNotNull("Joined field is null", joined);

        Card card = new Card(client, bookRepo.load(idBook), true);
        client.getCards().add(card);

        clientRepo.update(client);

        Client expClient = clientRepo.load(idClient);
        assertTrue(expClient.getCards().contains(card));
        assertEquals(joined, expClient.getJoined());
    }

    @Test public void testLoadAllCards() {

        final Integer id = 3;

        Client client = clientRepo.load(id);

        for (Card card : client.getCards())
            assertEquals(id, card.getClient().getId());
    }

    @Test public void testGetClient() {

        final Integer id = 3;
        final Set<Client> clients = clientRepo.loadAll();

        Client client = clientRepo.get(clients, id);
        assertNotNull(client);
        assertNotNull(client.getCards());
        assertNotEquals(0 , client.getCards().size());


        Client expClient = clientRepo.load(id);
        assertEquals(expClient, client);
        assertEquals(expClient.getCards(), client.getCards());
        assertEquals(expClient.getCards().size(), client.getCards().size());

        assertNull(clientRepo.get(clients, 100));
    }

    @Test public void testAuthentication() {

        for (Client client : clientRepo.loadAll()) {

            final String email = client.getEmail(), pwd = client.getPassword();

            Client expectedClient = clientRepo.authentication(email, pwd);

            assertTrue(expectedClient.equals(client));
        }
    }
}

