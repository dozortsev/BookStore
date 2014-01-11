package com.dozortsev.bookstore.test;

import com.dozortsev.bookstore.data.AuthorRepo;
import com.dozortsev.bookstore.data.BookRepo;
import com.dozortsev.bookstore.data.CardRepo;
import com.dozortsev.bookstore.data.ClientRepo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/test-applicationContext.xml")
public abstract class TestContext {

    @Autowired protected CardRepo cardRepo;

    @Autowired protected BookRepo bookRepo;

    @Autowired protected AuthorRepo authorRepo;

    @Autowired protected ClientRepo clientRepo;

    /* todo: add messages on test classes */
}
