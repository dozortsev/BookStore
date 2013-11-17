package dozortsev.bookstore.data;

import dozortsev.bookstore.model.Book;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Repository
@Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)

public class BookRepoImpl extends BaseRepoImpl<Integer, Book> implements BookRepo {

        private static final Logger log = getLogger(BookRepoImpl.class);

        public BookRepoImpl() {
                setEntityClass(Book.class);
        }

        @Override public List<Book> getAllBooks() {
                List<Book> list = null;
                try {
                        log.info("Loading all Books.");
                        list = getSession().createCriteria(Book.class).list();
                        log.info("Successful loaded.");

                } catch (HibernateException e) {
                        log.error("Error:", e);
                }
                return list;
        }
}
