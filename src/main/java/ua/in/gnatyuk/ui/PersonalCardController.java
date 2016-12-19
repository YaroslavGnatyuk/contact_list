package ua.in.gnatyuk.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;
import ua.in.gnatyuk.entity.Contact;

/**
 * Created by yroslav on 12/19/16.
 */
//ua.in.gnatyuk.ui.PersonalCardController
public class PersonalCardController {
    @FXML private Label fullName;
    @FXML private Label telephone;
    @FXML private Label email;
    @FXML private ImageView photo;

    public PersonalCardController() {
    }

    public void setAllPersonalData(Contact contact){
        fullName.setText(contact.getName());
        telephone.setText(contact.getPhone());
        email.setText(contact.getEmail());
    }

    @FXML
    public void initialize(){

    }
}
