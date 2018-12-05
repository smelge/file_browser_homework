package com.example.fileBrowser.components;

import com.example.fileBrowser.models.Files;
import com.example.fileBrowser.models.Folders;
import com.example.fileBrowser.models.Users;
import com.example.fileBrowser.repositories.FilesRepository;
import com.example.fileBrowser.repositories.FoldersRepository;
import com.example.fileBrowser.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FilesRepository filesRepository;
    @Autowired
    FoldersRepository foldersRepository;
    @Autowired
    UsersRepository usersRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Users user1 = new Users("Barry");
        Users user2 = new Users("Salacious");
        usersRepository.save(user1);
        usersRepository.save(user2);

        Folders folder1 = new Folders("Photos",user1);
        Folders folder2 = new Folders("Documents",user2);
        Folders folder3 = new Folders("Jams",user1);
        foldersRepository.save(folder1);
        foldersRepository.save(folder2);
        foldersRepository.save(folder3);

        Files file1 = new Files("dog","jpg",320,folder1);
        Files file2 = new Files("strudels","png",120,folder1);
        Files file3 = new Files("cat","bmp",32000,folder1);
        Files file4 = new Files("strawberry","jpg",231,folder3);
        Files file5 = new Files("funnycats","gif",3200,folder2);
        Files file6 = new Files("blackbook","word",0,folder2);
        filesRepository.save(file1);
        filesRepository.save(file2);
        filesRepository.save(file3);
        filesRepository.save(file4);
        filesRepository.save(file5);
        filesRepository.save(file6);
    }
}
