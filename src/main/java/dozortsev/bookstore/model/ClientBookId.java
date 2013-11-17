package dozortsev.bookstore.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ClientBookId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "idClient", nullable = false)
        private Client client;

        @ManyToOne
        @JoinColumn(name = "idBook", nullable = false)
        private Book book;

        public Client getClient() {
                return client;
        }
        public void setClient(Client client) {
                this.client = client;
        }

        public Book getBook() {
                return book;
        }
        public void setBook(Book book) {
                this.book = book;
        }
}
