package com.example.fileBrowser.projections;

import com.example.fileBrowser.models.Folders;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="embedUser",types= Folders.class)
public interface EmbedUser {
    String getName();
    String getExtension();
    int getSize();
    Folders getFolders();
}
