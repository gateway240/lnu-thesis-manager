package se.lnu.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class Role  {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
