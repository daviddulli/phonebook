package org.fasttrackit.service;

import org.fasttrackit.domain.Contact;
import org.fasttrackit.persistance.ContactRepository;
import org.fasttrackit.transfer.CreateContactRequest;
import org.fasttrackit.transfer.EditContactRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ContactService {

    private ContactRepository contactRepository = new ContactRepository();

    public void createContact(CreateContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating contact: " + request);
        contactRepository.createContact(request);

    }

    public void editContact(String firstName, String lastName, EditContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Editing contact: " + firstName + " " + lastName +  " " + request);
        contactRepository.editContact(firstName, lastName, request);

    }

    public void  deleteContact(String firstName, String lastName) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting contact: " + firstName + " " + "lastName...");
        contactRepository.deleteContact(firstName, lastName);

    }

    public void deleteContact(int id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting contact: " + id);
        contactRepository.deleteContact(id);

    }

    public List<Contact> getContacts() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving all contacts...");
        return contactRepository.getContacts();
    }




}
