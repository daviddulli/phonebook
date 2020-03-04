package org.fasttrackit;

import org.fasttrackit.domain.Contact;
import org.fasttrackit.persistance.ContactRepository;
import org.fasttrackit.transfer.CreateContactRequest;
import org.fasttrackit.transfer.EditContactRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        ContactRepository contactRepository = new ContactRepository();
        contactRepository.deleteContact("First", "Last");
        contactRepository.deleteContact(1);





    }
}
