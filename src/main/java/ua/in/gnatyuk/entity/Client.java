package ua.in.gnatyuk.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "contact")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_data")
    private String passport;

    @Column(name = "dob")
    private Date dob;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(name = "amount_of_visits")
    private Integer amountOfVisits;

    @Column(name = "total_spent")
    private Double totalSpent;

    @Column(unique = true, name = "google_drive_file_id")
    private String googleDrivePhotoId;

    public Client(String firstName, String lastName, String passport, Date dob, String phone, String email, Integer amountOfVisits, Double totalSpent, String googleDrivePhotoId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.amountOfVisits = amountOfVisits;
        this.totalSpent = totalSpent;
        this.googleDrivePhotoId = googleDrivePhotoId;
    }

    public Client(String firstName, String phone, String email) {
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;

        this.lastName = "default";
        this.passport = "default";
        this.dob = Date.valueOf(LocalDate.now());
        this.amountOfVisits = 0;
        this.totalSpent = 0.0D;
    }

    public void setGoogleDriveFileID(String googleDriveFileID) {
        this.googleDrivePhotoId= googleDriveFileID;
    }

    public String getGoogleDriveFileID() {
        return googleDrivePhotoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public Integer getAmountOfVisits() {
        return amountOfVisits;
    }

    public void setAmountOfVisits(Integer amountOfVisits) {
        this.amountOfVisits = amountOfVisits;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }
}
