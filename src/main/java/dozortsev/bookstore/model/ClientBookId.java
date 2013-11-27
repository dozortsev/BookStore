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


        @Override public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                ClientBookId that = (ClientBookId) o;

                if (!book.equals(that.book)) return false;
                if (!client.equals(that.client)) return false;

                return true;
        }

        @Override public int hashCode() {
                int result = client.hashCode();
                result = 31 * result + book.hashCode();
                return result;
        }
}
