package kidchai.springsecuritydemo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "Username is required")
    @Size(min = 10, max = 100, message = "Username must be at least 5 characters and no more than 100 characters")
    private String username;

    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Year of birth must be greater than 1900. In case you were wondering, the oldest person alive today was born in 1903.")
    private int yearOfBirth;

    @Column(name = "password")
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
