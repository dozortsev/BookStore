package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthorRepoImpl extends BaseRepoImpl<Integer, Author> implements AuthorRepo {

        public AuthorRepoImpl() {
                setEntityClass(Author.class);
        }
}
