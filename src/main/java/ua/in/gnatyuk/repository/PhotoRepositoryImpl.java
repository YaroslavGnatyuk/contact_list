package ua.in.gnatyuk.repository;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.in.gnatyuk.utils.MimeType;
import ua.in.gnatyuk.utils.MyGoogleDrive;

import java.io.IOException;

@Component
public class PhotoRepositoryImpl implements PhotoRepository {

    @Autowired
    @Qualifier("googleDrive")
    private MyGoogleDrive googleDrive;

    private String googleDriveFolderWithPhoto = "photos_contact_list";

    @Override
    public boolean upload(java.io.File photo) {
        try {
            Drive drive = googleDrive.getDriveService();

            File body = new File();
            body.setTitle(photo.getName());
            body.setMimeType(MimeType.JPEG.name());

           /* String folderID = drive
                    .files()
                    .list()
                    .setMaxResults(Integer.MAX_VALUE)
                    .execute()
                    .getItems()
                    .stream()
                    .filter(e -> e.getTitle().equals(googleDriveFolderWithPhoto))
                    .findAny().get().getId();*/

            FileList result = drive.files().list()
                    .setMaxResults(Integer.MAX_VALUE)
                    .execute();

            long count = result.getItems().stream().filter(e -> e.getTitle().equals("DP_1M_DMKD_clients.zip")).count();
            System.out.println("I have found: " + count
                    + " Total files was found: " + result.getItems().size());

            /*if (folderID != null && folderID.length() > 0) {
                body.setParents(
                        Arrays.asList(new ParentReference().setId(folderID)));
            }

            FileContent mediaContent = new FileContent(MimeType.JPEG.name(), photo);
            File file = drive.files().insert(body, mediaContent).execute();

            String photoID = file.getId();

            return photoID != null ? true : false;*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void delete(String photo) {

    }

    @Override
    public java.io.File download() {
        return null;
    }
}
