package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientRepoImpl extends BaseRepoImpl<Integer, Client> implements ClientRepo {

        public ClientRepoImpl() {
                setEntityClass(Client.class);
        }
}
