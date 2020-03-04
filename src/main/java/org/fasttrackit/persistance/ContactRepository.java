package org.fasttrackit.persistance;

import org.fasttrackit.domain.Contact;
import org.fasttrackit.transfer.CreateContactRequest;
import org.fasttrackit.transfer.EditContactRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {



    public void createContact(CreateContactRequest request) throws SQLException, IOException, ClassNotFoundException {

        String sql = "INSERT INTO phonebook (firstName, lastName, phoneNumber) VALUES (?,?,?)";

        try(Connection connection = new DatabaseConfiguration().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){


            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getPhoneNumber());
            preparedStatement.executeUpdate();

        }


    }

    public void editContact(String firstName, String lastName, EditContactRequest request) throws SQLException, IOException, ClassNotFoundException {

        String sql = "UPDATE phonebook SET phoneNumber = ? WHERE firstName = ? AND lastName = ?";


        try (Connection connection = new DatabaseConfiguration().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getPhoneNumber());
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);

            preparedStatement.executeUpdate();


        }

    }

    public void deleteContact(String firstName, String lastName) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM phonebook WHERE firstName = ? AND lastName = ?";

        try(Connection connection = new DatabaseConfiguration().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            preparedStatement.executeUpdate();
        }



    }

    public void deleteContact(int id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM phonebook WHERE id = ?";
        try(Connection connection = new DatabaseConfiguration().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }
    }

    public List<Contact> getContacts() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT firstname, lastname, phoneNumber FROM phonebook";
        try(Connection connection = new  DatabaseConfiguration().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            List<Contact> contacts = new ArrayList<>();

            while(resultSet.next()){
                Contact contact = new Contact();
                contact.getFirstName(resultSet.getString("firstName"));
                contact.getLastName(resultSet.getString("lastname"));
                contact.getPhoneNumber(resultSet.getString("phoneNumber"));
                contacts.add(contact);

            }
            return contacts;

    }

    }


}
