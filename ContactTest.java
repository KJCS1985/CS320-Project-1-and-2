package contacttest;

import contact.Contact;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private static final String VALID_ID = "200";
    private static final String VALID_FIRST = "Olivia";
    private static final String VALID_LAST = "Jones";
    private static final String VALID_PHONE = "9876543210";
    private static final String VALID_ADDRESS = "789 Elm St";

    // This test checks that a valid Contact object is created with correct values.
    @Test
    public void testContactCreation_withValidData_createsCorrectObject() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_ID, contact.getContactId());
        assertEquals(VALID_FIRST, contact.getFirstName());
        assertEquals(VALID_LAST, contact.getLastName());
        assertEquals(VALID_PHONE, contact.getPhone());
        assertEquals(VALID_ADDRESS, contact.getAddress());
    }

    // This test checks that a null ID throws an exception when creating a Contact.
    @Test
    public void testContactCreation_withNullId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    // This test checks that an overly long ID throws an exception.
    @Test
    public void testContactCreation_withLongId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123456789012", VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS));
    }

    // This test checks that setting a null first name throws an exception.
    @Test
    public void testSetFirstName_withInvalidInput_throwsException() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    // This test checks that the equals method returns true for two identical Contacts.
    @Test
    public void testEquals_withSameValues_returnsTrue() {
        Contact c1 = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        Contact c2 = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertTrue(c1.equals(c2));
    }

    // This test checks that the equals method returns false for different Contact values.
    @Test
    public void testEquals_withDifferentValues_returnsFalse() {
        Contact c1 = new Contact("1", "A", "B", "1234567890", "Addr1");
        Contact c2 = new Contact("2", "X", "Y", "0987654321", "Addr2");
        assertFalse(c1.equals(c2));
    }
}
