package com.example.fileBrowser.repositories;

import com.example.fileBrowser.models.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files,Long> {
}
