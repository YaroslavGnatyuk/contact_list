package ua.in.gnatyuk.service;

import ua.in.gnatyuk.entity.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    List<Client> findAll();

    void deleteByID(long id);

    void delete(Client client);

    Client findOne(long id);

    void updateContact(Client client);

    String uploadPhoto(java.io.File photo);

    boolean deletePhoto(String photo);

    java.io.File downloadPhoto(String photosId);

    String getFileIDByFileName(String fileName);
}
