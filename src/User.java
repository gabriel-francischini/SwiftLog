// import org.hibernate.annotations.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getters and setters

}
