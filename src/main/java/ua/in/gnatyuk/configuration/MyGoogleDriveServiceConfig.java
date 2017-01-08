package ua.in.gnatyuk.configuration;

import com.google.api.services.drive.Drive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.in.gnatyuk.utils.MyGoogleDrive;

import java.io.IOException;

@Configuration
public class MyGoogleDriveServiceConfig {

    @Bean(name="googleDrive")
    public Drive getGoogleDrive() throws IOException {
        return MyGoogleDrive.getDriveService();
    }
}
