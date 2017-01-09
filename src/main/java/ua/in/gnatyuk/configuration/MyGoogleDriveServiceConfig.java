package ua.in.gnatyuk.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.in.gnatyuk.utils.MyGoogleDrive;

import java.io.IOException;

@Configuration
//@ComponentScan("ua.in.gnatyuk")
public class MyGoogleDriveServiceConfig {

    @Bean(name = "googleDrive")
    public MyGoogleDrive getGoogleDrive() throws IOException {
        return new MyGoogleDrive();
    }
}
