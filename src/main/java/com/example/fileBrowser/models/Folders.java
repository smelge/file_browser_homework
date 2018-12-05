package com.example.fileBrowser.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="folders")
public class Folders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private Users user;

    @ManyToMany
    @JoinTable(
            name="folders_files",
            joinColumns = {
                    @JoinColumn(
                            name="folder_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="file_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Files> files;

    public Folders(String title, Users user) {
        this.title = title;
        this.user = user;
        this.files = new ArrayList<>();
    }

    public Folders() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void addFiles(Files files) {
        this.files.add(files);
    }
}
