package se.lnu.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Role extends AbstractEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
