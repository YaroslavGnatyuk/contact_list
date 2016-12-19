package ua.in.gnatyuk.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ua.in.gnatyuk.configuration.ConfigurationControllers;
import ua.in.gnatyuk.entity.Contact;
import ua.in.gnatyuk.service.ContactService;

import javax.annotation.PostConstruct;
import java.util.List;

public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    @Qualifier("personalCard")
    ConfigurationControllers.View personalCard;

    Stage personalCardStage;

    @FXML
    private TableView<Contact> table;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;

    private ObservableList<Contact> data;

    @FXML
    public void initialize() {
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        List<Contact> contacts = contactService.findAll();
        data = FXCollections.observableArrayList(contacts);

        // Столбцы таблицы
        TableColumn<Contact, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Contact, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Contact, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().setAll(idColumn, nameColumn, phoneColumn, emailColumn);

        // Данные таблицы
        table.setItems(data);
    }

    @FXML
    public void addContact() {
        Contact contact = new Contact(txtName.getText(), txtPhone.getText(), txtEmail.getText());
        contactService.save(contact);
        data.add(contact);

        // чистим поля
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @FXML
    public void openPersonalCard() {
        setUpPersonalData();
        if(personalCardStage == null) {
            personalCardStage = new Stage();
            personalCardStage.setScene(new Scene(personalCard.getView()));
            personalCardStage.show();
        }else {
            personalCardStage.show();
        }
    }

    private void setUpPersonalData(){
        Contact contact = table.getSelectionModel().getSelectedItem();
        PersonalCardController cardController = (PersonalCardController) personalCard.getController();
        cardController.setAllPersonalData(contact);
    }
}
