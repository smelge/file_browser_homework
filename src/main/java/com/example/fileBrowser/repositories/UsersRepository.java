package com.example.fileBrowser.repositories;

import com.example.fileBrowser.models.Users;
import com.example.fileBrowser.projections.EmbedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedUser.class)
public interface UsersRepository extends JpaRepository<Users, Long> {
}
