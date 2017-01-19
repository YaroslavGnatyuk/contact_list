package ua.in.gnatyuk.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true, name = "google_drive_file_id")
    private String googleDrivePhotoId;

    public Client() {
    }

    public Client(String name, String phone, String email, String googleDriveFileID) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.googleDrivePhotoId = googleDriveFileID;
    }

    public Client(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleDriveFileID() {
        return googleDrivePhotoId;
    }

    public void setGoogleDriveFileID(String googleDriveFileID) {
        this.googleDrivePhotoId = googleDriveFileID;
    }
}
