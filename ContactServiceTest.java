//Matthew R. Leclerc
//Southern New Hampshire University
//Module 6 Project One
//February 17th 2024

package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    // Test adding and retrieving a contact
    @Test
    void testAddAndGetContact() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main St");
        assertAll("Ensure the contact is added correctly",
                () -> assertEquals("John", service.getContact("1").getFirstName()),
                () -> assertEquals("Doe", service.getContact("1").getLastName()),
                () -> assertEquals("1234567890", service.getContact("1").getPhone()),
                () -> assertEquals("123 Main St", service.getContact("1").getAddress()));
    }

    // Test adding a contact with a duplicate ID
    @Test
    void testAddContactWithDuplicateId() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact("1", "Jane", "Smith", "0987654321", "456 Elm St"));
    }

    // Test deleting a contact
    @Test
    void testDeleteContact() {
        service.addContact("2", "Jane", "Doe", "0987654321", "456 Elm St");
        service.deleteContact("2");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("2"));
    }

    // Test updating a contact
    @Test
    void testUpdateContact() {
        service.addContact("3", "Mike", "Smith", "1112223333", "789 Pine St");
        service.updateContactFirstName("3", "Michael");
        assertEquals("Michael", service.getContact("3").getFirstName());
    }

    // Test handling of non-existent contacts
    @Test
    void testOperateOnNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("nonexistent"));
        assertThrows(IllegalArgumentException.class, () -> service.updateContactFirstName("nonexistent", "NoName"));
    }
}
