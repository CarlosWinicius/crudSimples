package model.entity;
import jakarta.persistence.*;
import org.jetbrains.annotations.Nullable;


@Entity
@Table(name = "users")
public class User {

    @Column(nullable= false)
    private String name;

    @Id
    @Column(nullable= false)
    private String email;

    public User(){

    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }

}

