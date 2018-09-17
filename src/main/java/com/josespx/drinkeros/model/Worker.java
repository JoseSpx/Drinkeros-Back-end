package com.josespx.drinkeros.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="worker")
public class Worker {

    public interface Basic {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Basic.class)
    private Long id;

    @Column(name = "name")
    @JsonView(Basic.class)
    private String name;

    @Column(name = "lastname")
    @JsonView(Basic.class)
    private String lastName;

    @Column(name = "dni", length = 20)
    @JsonView(Basic.class)
    private String dni;

    @Column(name = "email", length = 100)
    @JsonView(Basic.class)
    private String email;

    @Column(name = "phone")
    @JsonView(Basic.class)
    private String phone;

    @Column(name = "address")
    @JsonView(Basic.class)
    private String address;

    @Column(name = "eliminated", columnDefinition = "char(1) default '0'")
    private String eliminated;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Worker() { }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdated() {
        this.updatedAt = LocalDateTime.now();
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEliminated() {
        return eliminated;
    }

    public void setEliminated(String eliminated) {
        this.eliminated = eliminated;
    }
}
