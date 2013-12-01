package dozortsev.bookstore.test;

import dozortsev.bookstore.data.AuthorRepo;
import dozortsev.bookstore.data.BookRepo;
import dozortsev.bookstore.data.ClientRepo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/test-applicationContext.xml")
public abstract class TestContext {

        @Autowired
        protected ClientRepo clientRepo;

        @Autowired
        protected BookRepo bookRepo;

        @Autowired
        protected AuthorRepo authorRepo;
}
