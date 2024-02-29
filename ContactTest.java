//Matthew R. Leclerc
//Southern New Hampshire University
//Module 6 Project One
//February 17th 2024

package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test creating a valid contact
    @Test
    void testContactCreation() {
        assertDoesNotThrow(() -> new Contact("1", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test contact ID constraints
    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test firstName constraints
    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "JohnathanSmith", "Doe", "1234567890", "123 Main St"));
    }

    // Test lastName constraints
    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "DoeLongLastName", "1234567890", "123 Main St"));
    }

    // Test phone number constraints
    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345678901", "123 Main St"));
    }

    // Test address constraints
    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", "123 Main Street That Is Way Too Long"));
    }
}
