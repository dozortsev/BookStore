package dozortsev.bookstore.data;

import dozortsev.bookstore.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;


@Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
@Repository
public class AuthorRepoImpl extends BaseRepoImpl<Integer, Author> implements AuthorRepo {

    public AuthorRepoImpl() {
        setEntityClass(Author.class);
    }
}
