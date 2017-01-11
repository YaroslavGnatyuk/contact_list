package ua.in.gnatyuk.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.in.gnatyuk.utils.MyGoogleDrive;

import java.io.IOException;

@Configuration
public class MyGoogleDriveServiceConfig {

    @Bean(name = "googleDrive")
    public MyGoogleDrive getGoogleDrive() throws IOException {
        return new MyGoogleDrive();
    }
}
