package com.blackswan.codetest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Mark Andrews
 */
@Entity
@Table(name="USER")
@JsonPropertyOrder({"id", "username", "first_name", "last_name"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @JsonProperty("first_name")
    @Column(name="FIRSTNAME")
    private String firstName;

    @JsonProperty("last_name")
    @Column(name="LASTNAME")
    private String lastName;

    @JsonProperty("username")
    @Column(name="USERNAME")
    private String username;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, targetEntity = Task.class)
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Username = "+username+" : Firstname = "+firstName+" : Lastname = "+lastName+".";
    }
}
