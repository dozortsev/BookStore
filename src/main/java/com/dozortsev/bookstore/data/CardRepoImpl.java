package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Card;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
@Repository
public class CardRepoImpl extends BaseRepoImpl<Integer, Card> implements CardRepo {

    private static final Logger log = getLogger(CardRepoImpl.class);

    public CardRepoImpl() {
        setEntityClass(Card.class);
    }
}
