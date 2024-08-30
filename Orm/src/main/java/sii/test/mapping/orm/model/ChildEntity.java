package sii.test.mapping.orm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "child")
public class ChildEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public ChildEntity(String name) {
        this.name = name;
    }

    public ChildEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}