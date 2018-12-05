package com.example.fileBrowser.repositories;

import com.example.fileBrowser.models.Folders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoldersRepository extends JpaRepository<Folders,Long> {
}
