package ua.in.gnatyuk;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import ua.in.gnatyuk.configuration.ConfigurationControllers;

@Lazy(value = false)
@SpringBootApplication
@ComponentScan("ua.in.gnatyuk")
public class Application extends AbstractJavaFxApplicationSupport {

    @Value("${ui.title:JavaFX приложение}")//
    private String windowTitle;

    @Qualifier("mainView")
    @Autowired
    private ConfigurationControllers.View mainView;

    @Autowired
    @Qualifier("personalCard")
    ConfigurationControllers.View personalCard;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(mainView.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

}
