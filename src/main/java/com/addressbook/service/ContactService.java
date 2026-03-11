package com.addressbook.service;

import com.addressbook.model.Contact;
import com.addressbook.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact getContactById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Contact updateContact(Long id, Contact contact) {

        Contact existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setFirstName(contact.getFirstName());
            existing.setLastName(contact.getLastName());
            existing.setAddress(contact.getAddress());
            existing.setCity(contact.getCity());
            existing.setState(contact.getState());
            existing.setZip(contact.getZip());
            existing.setPhone(contact.getPhone());
            existing.setEmail(contact.getEmail());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}