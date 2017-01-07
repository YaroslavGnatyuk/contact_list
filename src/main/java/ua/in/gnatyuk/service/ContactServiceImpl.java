package ua.in.gnatyuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.entity.Contact;
import ua.in.gnatyuk.repository.ContactRepository;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteByID(long id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        repository.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findOne(long id) {
        return repository.findOne(id);
    }
}
