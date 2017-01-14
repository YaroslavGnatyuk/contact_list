package ru.habrahabr;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.MyGoogleDriveServiceConfig;
import ua.in.gnatyuk.repository.PhotoRepository;
import ua.in.gnatyuk.repository.GoogleDrivePhotoRepositoryImpl;

import java.io.File;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("ua.in.gnatyuk")
@ContextConfiguration(classes = {GoogleDrivePhotoRepositoryImpl.class, MyGoogleDriveServiceConfig.class})
public class ApplicationTests {
	@Autowired
	private PhotoRepository photoRepository;
	private String photosName = "default_photo.jpg";

//	@Ignore
	@Test
	public void uploadPhotoToMyGoogleDrive(){
		File photo = new File("D:\\Books\\prj\\contact_list\\src\\main\\resources\\img\\" + photosName);
		assertNotNull(photoRepository.uploadPhoto(photo));

	}

	@Ignore
	@Test
	public void downLoadPhoto(){
		try {
			Thread.sleep(5000);
			String photosID = photoRepository.getFileIDByFileName(photosName);
			File photo = photoRepository.downloadPhoto(photosID);
			assertTrue(photo != null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void deletePhoto(){
		try {
			Thread.sleep(5000);
			String photosID = photoRepository.getFileIDByFileName(photosName);
			assertTrue(photoRepository.deletePhoto(photosID));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
