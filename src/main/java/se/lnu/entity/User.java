package se.lnu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User extends AbstractEntity {

    private String firstName;

    private String lastName;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "author")
    private List<Document> documents = new ArrayList<>();

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addDocument(Document document){
        this.documents.add(document);
        document.setAuthor(this);
    }
}
