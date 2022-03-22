package tk.propensi.medix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=300)
    @Column(name="username", nullable = false)
    private String username;

    @NotNull
    @Size(max=200)
    @Column(name="firstname", nullable = false)
    private String firstname;

    @Size(max=200)
    @Column(name="lastname")
    private String lastname;

    @NotNull
    @Size(max=400)
    @Column(name="email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "password",nullable = false)
    private String password;

    @NotNull
    @Column(name = "status",nullable = false)
    private int status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RoleModel role;
}
