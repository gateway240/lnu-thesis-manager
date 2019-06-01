package se.lnu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private String email;

    @Id
    private String username;

    private String password;

    private Boolean enabled;

    private String grade;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Submission> submissions = new ArrayList<>();

    @ManyToMany
            @JoinTable(
                    name="user_coordinators",
                    joinColumns = @JoinColumn(name = "username"),
                    inverseJoinColumns = @JoinColumn(name = "coordinator")
            )
    Set<User> coordinatedUsers;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public Set<User> getCoordinatedUsers() {
        return coordinatedUsers;
    }

    public void setCoordinatedUsers(Set<User> coordinatedUsers) {
        this.coordinatedUsers = coordinatedUsers;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    public void addDocument(Document document){
        this.documents.add(document);
        document.setAuthor(this);
    }
}
