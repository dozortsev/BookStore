package dozortsev.bookstore.data;

import dozortsev.bookstore.model.Client;

public interface ClientRepo extends BaseRepo<Integer, Client> {

    public Client authentication(String email, String password);

}
