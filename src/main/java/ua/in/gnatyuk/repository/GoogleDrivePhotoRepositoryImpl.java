package ua.in.gnatyuk.repository;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.ParentReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.in.gnatyuk.utils.MyGoogleDrive;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Component
public class GoogleDrivePhotoRepositoryImpl implements PhotoRepository {

    @Autowired
    @Qualifier("googleDrive")
    private MyGoogleDrive googleDrive;

    @Override
    public String upload(java.io.File photo) {
        try {
            Drive drive = googleDrive.getDriveService();

            File googleDriveFile = new File();
            googleDriveFile.setTitle(photo.getName());
            googleDriveFile.setParents(Arrays.asList(new ParentReference().setId(MyGoogleDrive.ID_FOLDER_WITH_PHOTO)));

            FileContent mediaContent = new FileContent(MyGoogleDrive.MIME_TYPE_FOR_PHOTO, photo);

            return drive.files().insert(googleDriveFile, mediaContent).execute().getId();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(String photosId) {
        try {
            Drive drive = googleDrive.getDriveService();
            drive.files().delete(photosId).execute();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public java.io.File download(String photosId) {
        try {
            Drive drive = googleDrive.getDriveService();
            java.io.File tempFileForPhoto = new java.io.File("/temp/");
            FileOutputStream fileOutputStream = new FileOutputStream(tempFileForPhoto);
            drive.files().get(photosId).executeMediaAndDownloadTo(fileOutputStream);

            return tempFileForPhoto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
