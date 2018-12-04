package com.example.fileBrowser.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Folders> folder;

    public Users(String name, List<Folders> folder) {
        this.name = name;
        this.folder = new ArrayList<>();
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folders> getFolder() {
        return folder;
    }

    public void setFolder(List<Folders> folder) {
        this.folder = folder;
    }
}
