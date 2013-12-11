package dozortsev.bookstore.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static org.hibernate.annotations.CascadeType.DELETE;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Table(name = "Client")
public class Client extends AbstractEntity<Integer> {

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "Surname", length = 100, nullable = false)
    private String surname;

    @Column(name = "Email", length = 200, unique = true, nullable = false)
    private String email;

    @Column(name = "Password", length = 15, unique = true, nullable = false)
    private String password;

    @OneToMany(fetch = EAGER, mappedBy = "idCard.client")
    @Cascade({SAVE_UPDATE, DELETE})
    private Set<Card> cards = new LinkedHashSet<>();


    public Client() {
    }

    public Client(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Client(String name, String surname, String email, String password, Set<Card> cards) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.cards = cards;
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

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!email.equals(client.email)) return false;
        if (!name.equals(client.name)) return false;
        if (!password.equals(client.password)) return false;
        if (!surname.equals(client.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
