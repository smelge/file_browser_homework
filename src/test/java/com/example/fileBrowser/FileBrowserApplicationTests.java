package com.example.fileBrowser;

import com.example.fileBrowser.models.Files;
import com.example.fileBrowser.models.Folders;
import com.example.fileBrowser.models.Users;
import com.example.fileBrowser.repositories.FilesRepository;
import com.example.fileBrowser.repositories.FoldersRepository;
import com.example.fileBrowser.repositories.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileBrowserApplicationTests {

	@Autowired
	FilesRepository filesRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	FoldersRepository foldersRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUserandFolder(){
		Users user = new Users("Jacob Mince");
		usersRepository.save(user);

		Folders folders = new Folders("Cat Photos",user);
		foldersRepository.save(folders);
	}

	@Test
	public void addEverything(){
		Users user = new Users("Peter Pancake");
		usersRepository.save(user);

		Folders folders = new Folders("Weird Stuff",user);
		foldersRepository.save(folders);

		Files file = new Files("gravyboats","jpg",3200,folders);
		filesRepository.save(file);

		file.addFolder(folders);
		filesRepository.save(file);

	}

}
