package sii.test.mapping.orm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "root")
public class RootEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<ChildEntity> chidren = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<ChildEntity> getChidren() {
        return chidren;
    }

    public void setChidren(List<ChildEntity> chidren) {
        this.chidren = chidren;
    }
}
