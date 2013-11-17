package dozortsev.bookstore.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "Client")
public class Client extends AbstractEntity<Integer> {

        @Column(name = "Name", length = 100)
        private String name;

        @Column(name = "Surname", length = 100)
        private String surname;

        @Column(name = "Password", length = 15, unique = true, nullable = false)
        private String password;

        @Column(name = "Email", length = 200, unique = true, nullable = false)
        private String email;

        @OneToMany(fetch = EAGER, mappedBy = "clientBookId.client")
        private List<ClientBook> books = new ArrayList<>();


        public Client() {
        }

        public Client(String name, String surname, String password, String email) {
                this.name = name;
                this.surname = surname;
                this.password = password;
                this.email = email;
        }

        public Client(String name, String surname, String password, String email, List<ClientBook> books) {
                this.name = name;
                this.surname = surname;
                this.password = password;
                this.email = email;
                this.books = books;
        }

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }

        public String getSurname() {
                return surname;
        }
        public void setSurname(String surname) {
                this.surname = surname;
        }

        public String getPassword() {
                return password;
        }
        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }

        public List<ClientBook> getBooks() {
                return books;
        }
        public void setBooks(List<ClientBook> books) {
                this.books = books;
        }
}
