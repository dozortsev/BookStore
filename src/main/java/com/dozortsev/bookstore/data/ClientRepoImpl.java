package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;
import static org.hibernate.criterion.Restrictions.like;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
@Repository
public class ClientRepoImpl extends BaseRepoImpl<Integer, Client> implements ClientRepo {

    private static final Logger log = getLogger(ClientRepoImpl.class);

    public ClientRepoImpl() {
        setEntityClass(Client.class);
    }

    @Transactional(readOnly = true)
    @Override public Client authentication(String email, String pwd) {
        Client client = null;
        try {
            log.info(format("Authentication client. Email: '%s'", email));

            Criteria crit = getSession().createCriteria(getEntityClass());

            client = (Client) crit.add(like("email", email))
                                  .add(like("password", pwd))
                                  .uniqueResult();

            if (client == null) {
                log.info("Client not found");
                return null;
            }
            log.info(format("Successful founded. Id: %s", client.getId()));

        } catch (HibernateException e) {
            log.error("Error:", e);
        }
        return client;
    }
}
