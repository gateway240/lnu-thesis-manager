package se.lnu.entity;

import javax.persistence.Entity;

@Entity
public class Role extends AbstractEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
