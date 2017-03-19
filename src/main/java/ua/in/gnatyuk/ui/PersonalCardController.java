package ua.in.gnatyuk.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import ua.in.gnatyuk.entity.Client;
import ua.in.gnatyuk.service.ClientService;

import java.io.*;

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
    private ClientService clientService;

    private Stage personalCard;
    private Client client;

    public void setAllPersonalData(Client client) {
        this.client = client;

        fullName.setText(client.getFirstName());
        telephone.setText(client.getPhone());
        email.setText(client.getEmail());
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
    //todo add checking all repositories (FinishedRent, CurrentRent and HotelRoomReservation)
    //todo if they contains records with this client they should delete this record
    public void deleteContact() {
        clientService.delete(client);
        mainController.getData().remove(client);
        if (client.getGoogleDriveFileID() != null) {
            clientService.deletePhoto(client.getGoogleDriveFileID());
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
            client.setGoogleDriveFileID(photoID);
            clientService.updateContact(client);
        }

        setImageToImageView();
    }

    private void setImageToImageView() {
        String fileID = client.getGoogleDriveFileID();
        if (fileID != null) {
            Image image = getContactPhoto(fileID);
            this.photo.setImage(image);
        } else {
            Image image = getDefaultPhoto();
            photo.setImage(image);
        }
    }

    private Image getContactPhoto(String fileID) {
        File photo = clientService.downloadPhoto(fileID);

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
            ClassPathResource resource = new ClassPathResource("/img/default_photo.jpg");
            InputStream inputStream = resource.getInputStream();
            return new Image(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method uploads file to repository and returns fileID
     **/
    private String uploadPhoto(File fileForUpload) {
        if (client.getGoogleDriveFileID() != null) {
            clientService.deletePhoto(client.getGoogleDriveFileID());
            return clientService.uploadPhoto(fileForUpload);
        } else {
            return clientService.uploadPhoto(fileForUpload);
        }
    }
}