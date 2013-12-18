package com.dozortsev.bookstore.util;

import com.dozortsev.bookstore.model.Book;
import com.dozortsev.bookstore.model.Card;
import com.dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Random;
import java.util.Set;

public class Util {

    private static final Logger log = Logger.getLogger(Util.class);

    public static final String DATE_SEPARATOR = "-";

    private final static Random rand = new Random();

    public static String getRandPassword() {
        return String.valueOf(rand.nextInt(1_000_000));
    }

    public static Set removeAll(Set<Book> books, Client client) {

        for (Card card : client.getCards())
            books.remove(card.getBook());

        return books;
    }

    public static Calendar dateParser(String s) {

        int i = 0;
        int[] arrDate = new int[3];
        Calendar date = Calendar.getInstance();

        for (String value : s.split(DATE_SEPARATOR))
            arrDate[i++] = Integer.valueOf(value);

        date.set(arrDate[0], arrDate[1], arrDate[2]);

        return date;
    }
}
