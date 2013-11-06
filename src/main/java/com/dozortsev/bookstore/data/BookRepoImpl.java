package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookRepoImpl extends BaseRepoImpl<Integer, Book> implements BookRepo {

        public BookRepoImpl() {
                setEntityClass(Book.class);
        }
}
