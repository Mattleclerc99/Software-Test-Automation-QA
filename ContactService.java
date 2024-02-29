//Matthew R. Leclerc
//Southern New Hampshire University
//Module 6 Project One
//February 17th 2024

package org.example;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, newContact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contacts.remove(contactId);
    }

    // Update contact's firstName
    public void updateContactFirstName(String contactId, String firstName) {
        validateContactExists(contactId);
        contacts.get(contactId).setFirstName(firstName);
    }

    // Update contact's lastName
    public void updateContactLastName(String contactId, String lastName) {
        validateContactExists(contactId);
        contacts.get(contactId).setLastName(lastName);
    }

    // Update contact's phone
    public void updateContactPhone(String contactId, String phone) {
        validateContactExists(contactId);
        contacts.get(contactId).setPhone(phone);
    }

    // Update contact's address
    public void updateContactAddress(String contactId, String address) {
        validateContactExists(contactId);
        contacts.get(contactId).setAddress(address);
    }

    // Retrieve a contact by ID
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        return contacts.get(contactId);
    }

    // Utility method to check if a contact exists
    private void validateContactExists(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
    }
}
