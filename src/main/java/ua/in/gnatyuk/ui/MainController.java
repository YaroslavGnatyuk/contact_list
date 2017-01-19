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
import ua.in.gnatyuk.entity.Client;
import ua.in.gnatyuk.service.ClientService;

import javax.annotation.PostConstruct;
import java.util.List;

public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    @Qualifier("personalCard")
    private ConfigurationControllers.View personalCardView;

    private Stage personalCardStage;

    ObservableList<Client> getData() {
        return data;
    }

    @FXML
    private TableView<Client> table;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;

    private ObservableList<Client> data;

    @FXML
    public void initialize() {
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {

        List<Client> clients = clientService.findAll();
        data = FXCollections.observableArrayList(clients);

        TableColumn<Client, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Client, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Client, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Client, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().setAll(idColumn, nameColumn, phoneColumn, emailColumn);

        table.setItems(data);
    }

    @FXML
    public void addContact() {
        Client client = new Client(txtName.getText(), txtPhone.getText(), txtEmail.getText());
        clientService.save(client);
        data.add(client);

        txtName.clear();
        txtPhone.clear();
        txtEmail.clear();
    }

    @FXML
    public void openPersonalCard() {
        Client client = table.getSelectionModel().getSelectedItem(); //I can get here NPE because the row can be empty in table
        if (client == null) {
            return;
        }

        table.getSelectionModel().clearSelection();

        if (personalCardStage == null) {
            personalCardStage = new Stage();
            personalCardStage.setScene(new Scene(personalCardView.getView()));
            setupPersonalData(client);
            personalCardStage.show();
        } else {
            setupPersonalData(client);
            personalCardStage.show();
        }
    }

    private void setupPersonalData(Client client) throws NullPointerException {
        PersonalCardController personalCardController = (PersonalCardController) personalCardView.getController();
        personalCardController.setPersonalCard(personalCardStage);
        personalCardController.setAllPersonalData(client);
    }
}