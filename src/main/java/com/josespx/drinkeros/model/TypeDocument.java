package com.josespx.drinkeros.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_document")
public class TypeDocument {

    public interface Basic {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Basic.class)
    private Long id;

    @Column(name = "name")
    @JsonView(Basic.class)
    private String name;

    @OneToMany(mappedBy = "typeDocument")
    private List<Client> clientList;

    public TypeDocument() {}

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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
