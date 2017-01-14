package ua.in.gnatyuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.entity.Contact;
import ua.in.gnatyuk.repository.ContactRepository;
import ua.in.gnatyuk.repository.PhotoRepository;

import java.io.File;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository personalDataRepository;
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return personalDataRepository.save(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return personalDataRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteByID(long id) {
        personalDataRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        personalDataRepository.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findOne(long id) {
        return personalDataRepository.findOne(id);
    }

    @Override
    @Transactional
    public void updateContact(Contact contact) {
        personalDataRepository.save(contact);
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
