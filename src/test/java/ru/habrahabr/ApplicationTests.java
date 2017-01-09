package ru.habrahabr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.MyGoogleDriveServiceConfig;
import ua.in.gnatyuk.repository.PhotoRepository;
import ua.in.gnatyuk.repository.PhotoRepositoryImpl;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("ua.in.gnatyuk")
@ContextConfiguration(classes = {PhotoRepositoryImpl.class, MyGoogleDriveServiceConfig.class})
public class ApplicationTests {
	@Autowired
	PhotoRepository photoRepository;

	@Test
	public void uploadPhotoToMyGoogleDrive(){
		File photo = new File("/home/yroslav/Downloads/emotional_and_rational_brain-wallpaper-1920x1080.jpg");
		photoRepository.upload(photo);
	}

}
