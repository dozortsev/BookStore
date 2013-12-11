package dozortsev.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import java.util.Calendar;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "Author")
public class Author extends AbstractEntity<Integer> {

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name = "Surname", length = 100, nullable = false)
    private String surname;

    @Column(name = "DOB", nullable = false)
    @Temporal(DATE)
    private Calendar dob;

    public Author() {
    }

    public Author(String name, String surname, Calendar dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
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

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }


    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!dob.equals(author.dob)) return false;
        if (!name.equals(author.name)) return false;
        if (!surname.equals(author.surname)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }
}
