package com.example.fileBrowser.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="extension")
    private String extension;
    @Column(name="size")
    private int size;

    @ManyToMany
    @JoinTable(
            name = "folders_files",
            joinColumns = {
                    @JoinColumn(
                            name="file_id",
                            nullable=false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="folder_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Folders> folders;

    public Files(String name, String extension, int size, Folders folders) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.folders = new ArrayList<>();
    }

    public Files() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Folders> getFolders() {
        return folders;
    }

    public void addFolder(Folders folders) {
        this.folders.add(folders);
    }
}
