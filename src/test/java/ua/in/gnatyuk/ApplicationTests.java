package ua.in.gnatyuk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.repository.impl.GoogleDrivePhotoRepositoryImpl;
import ua.in.gnatyuk.repository.PhotoRepository;
import ua.in.gnatyuk.utils.MyGoogleDrive;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("ua.in.gnatyuk")
@ContextConfiguration(classes = {GoogleDrivePhotoRepositoryImpl.class, MyGoogleDrive.class})
public class ApplicationTests {
	@Autowired
	private PhotoRepository photoRepository;
	private String photosName = "default_photo.jpg";

//	@Ignore
	@Test
	public void uploadPhotoToMyGoogleDrive(){
		Resource resource = new ClassPathResource("/img/default_photo.jpg");
		File photo = null;
		try {
			photo = resource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(photoRepository.uploadPhoto(photo));
	}

//	@Ignore
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

//	@Ignore
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
