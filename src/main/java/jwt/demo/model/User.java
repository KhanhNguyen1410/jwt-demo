package jwt.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "please enter username")
    private String username;
    @NotEmpty(message = "please enter password")
    private String password;
    private String fullName;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
