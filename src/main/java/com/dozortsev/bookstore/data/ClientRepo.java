package com.dozortsev.bookstore.data;

import com.dozortsev.bookstore.model.Client;

public interface ClientRepo extends BaseRepo<Integer, Client> {

    Client authentication(String email, String password);

}
