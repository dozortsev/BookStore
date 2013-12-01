package dozortsev.bookstore.data;

import dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import org.springframework.context.annotation.Scope;
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
                        log.info(format("Authentication client. Email: '%s'; Password: '%s'.", email, pwd));

                        Criteria crit = getSession().createCriteria(getEntityClass());

                        crit.add(like("email", email))
                            .add(like("password", pwd))
                            .setMaxResults(1);

                        if (crit.list().isEmpty()) {
                                log.info("Client not found.");
                                return null;
                        }
                        client = (Client) crit.list().get(0);

                        log.info("Successful founded.");

                } catch (HibernateException e) {
                        log.error("Error:", e);
                }
                return client;
        }
}
