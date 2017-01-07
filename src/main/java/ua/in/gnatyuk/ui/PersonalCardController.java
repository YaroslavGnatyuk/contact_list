package ua.in.gnatyuk.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import ua.in.gnatyuk.entity.Contact;
import ua.in.gnatyuk.service.ContactService;

//ua.in.gnatyuk.ui.PersonalCardController
public class PersonalCardController {
    @FXML private Label fullName;
    @FXML private Label telephone;
    @FXML private Label email;
    @FXML private ImageView photo;

    @Autowired
    private ContactService contactService;
    @Autowired
    private  MainController mainController;

    private Stage personalCard;
    private Contact contact;

    public void setAllPersonalData(Contact contact){
        fullName.setText(contact.getName());
        telephone.setText(contact.getPhone());
        email.setText(contact.getEmail());
        this.contact = contact;
    }

    public void setPersonalCard(Stage personalCard) {
        this.personalCard = personalCard;
    }

    @FXML
    public void initialize(){
    }

    @FXML
    public void deleteContact(){
        contactService.delete(contact);
        mainController.getData().remove(contact);
        closePersonalCard();
    }

    @FXML
    public void closePersonalCard(){
        this.personalCard.close();
    }
}