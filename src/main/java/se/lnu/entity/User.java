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

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "author")
    private List<Document> documents = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Submission> submissions = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL}, mappedBy = "user")
    private Set<UserSupervisor> supervisors;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL}, mappedBy = "user")
    private Set<UserCoordinator> coordinators;


    public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
		
	}

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

    public Set<UserCoordinator> getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(Set<UserCoordinator> coordinators) {
        this.coordinators = coordinators;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<UserSupervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Set<UserSupervisor> supervisors) {
        this.supervisors = supervisors;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    public void addDocument(Document document){
        this.documents.add(document);
        document.setAuthor(this);
    }
}
