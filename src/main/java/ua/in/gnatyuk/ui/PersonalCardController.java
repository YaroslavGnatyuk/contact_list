package ua.in.gnatyuk.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ua.in.gnatyuk.entity.Contact;
import ua.in.gnatyuk.service.ContactService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//ua.in.gnatyuk.ui.PersonalCardController
public class PersonalCardController {
    @FXML
    private Label fullName;
    @FXML
    private Label telephone;
    @FXML
    private Label email;
    @FXML
    private ImageView photo;

    @Autowired
    private MainController mainController;
    @Autowired
    private ContactService contactService;

    private Stage personalCard;
    private Contact contact;

    public void setAllPersonalData(Contact contact) {
        this.contact = contact;

        fullName.setText(contact.getName());
        telephone.setText(contact.getPhone());
        email.setText(contact.getEmail());
        setImageToImageView();

    }

    public void setPersonalCard(Stage personalCard) {
        this.personalCard = personalCard;
        this.personalCard.setTitle("Personal card");
    }

    @FXML
    public void initialize() {
    }

    @FXML
    public void deleteContact() {
        contactService.delete(contact);
        mainController.getData().remove(contact);
        if (contact.getGoogleDriveFileID() != null) {
            contactService.deletePhoto(contact.getGoogleDriveFileID());
        }
        closePersonalCard();
    }

    @FXML
    public void closePersonalCard() {
        this.personalCard.close();
    }

    @FXML
    private void openUploadDialog() {
        String photoID;
        int index = 1;

        final FileChooser fileChooser = new FileChooser();
        File fileForUpload = fileChooser.showOpenDialog(personalCard);

        if(fileForUpload == null){
            return;
        }
        String fileExtension = fileForUpload.getName().split("\\.")[index];
        if (fileExtension.equals("jpeg") || fileExtension.equals("jpg")) {
            photoID = uploadPhoto(fileForUpload);
            contact.setGoogleDriveFileID(photoID);
            contactService.updateContact(contact);
        }

        setImageToImageView();
    }

    private void setImageToImageView() {
        String fileID = contact.getGoogleDriveFileID();
        if (fileID != null) {
            Image image = getContactPhoto(fileID);
            this.photo.setImage(image);
        } else {
            Image image = getDefaultPhoto();
            photo.setImage(image);
        }
    }

    private Image getContactPhoto(String fileID) {
        File photo = contactService.downloadPhoto(fileID);

        try {
            FileInputStream fileInputStream = new FileInputStream(photo);
            return new Image(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Image getDefaultPhoto() {
        try {
            Resource resource = new ClassPathResource("/img/default_photo.jpg");
            FileInputStream fileInputStream = new FileInputStream(resource.getFile());
            return new Image(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method uploads file to repository and returns fileID
     **/
    private String uploadPhoto(File fileForUpload) {
        if (contact.getGoogleDriveFileID() != null) {
            contactService.deletePhoto(contact.getGoogleDriveFileID());
            return contactService.uploadPhoto(fileForUpload);
        } else {
            return contactService.uploadPhoto(fileForUpload);
        }
    }
}