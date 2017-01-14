package ua.in.gnatyuk.service;

import ua.in.gnatyuk.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    List<Contact> findAll();

    void deleteByID(long id);

    void delete(Contact contact);

    Contact findOne(long id);

    void updateContact(Contact contact);

    String uploadPhoto(java.io.File photo);

    boolean deletePhoto(String photo);

    java.io.File downloadPhoto(String photosId);

    String getFileIDByFileName(String fileName);
}
