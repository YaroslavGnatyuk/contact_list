package ua.in.gnatyuk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.entity.Client;
import ua.in.gnatyuk.repository.ClientRepository;
import ua.in.gnatyuk.repository.PhotoRepository;
import ua.in.gnatyuk.service.ClientService;

import java.io.File;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository personalDataRepository;
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    @Transactional
    public Client save(Client client) {
        return personalDataRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return personalDataRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteByID(long id) {
        personalDataRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        personalDataRepository.delete(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findOne(long id) {
        return personalDataRepository.findOne(id);
    }

    @Override
    @Transactional
    public void updateContact(Client client) {
        personalDataRepository.save(client);
    }

    @Override
    public String uploadPhoto(File photo) {
        return photoRepository.uploadPhoto(photo);
    }

    @Override
    public boolean deletePhoto(String photo) {
        return photoRepository.deletePhoto(photo);
    }

    @Override
    public File downloadPhoto(String photosId) {
        return photoRepository.downloadPhoto(photosId);
    }

    @Override
    public String getFileIDByFileName(String fileName) {
        return photoRepository.getFileIDByFileName(fileName);
    }
}
