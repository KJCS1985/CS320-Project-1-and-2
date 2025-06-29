package contacttest;

import contact.Contact;
import contact.ContactService;




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

public class ContactServiceTest {

    private ContactService service;

    private static final String ID = "101";
    private static final String FIRST = "Liam";
    private static final String LAST = "Brown";
    private static final String PHONE = "5551234567";
    private static final String ADDRESS = "123 Cedar Rd";

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    // This test checks that a contact can be added and retrieved successfully.
    @Test
    public void testAddContact_withValidContact_addsSuccessfully() {
        Contact c = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(c);
        assertEquals(FIRST, service.getContact(ID).getFirstName());
    }

    // This test checks that adding a contact with a duplicate ID throws an error.
    @Test
    public void testAddContact_withDuplicateId_throwsException() {
        Contact c1 = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        Contact c2 = new Contact(ID, "Eva", "Green", "5557654321", "456 Maple St");
        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    // This test checks that a contact can be deleted and is no longer retrievable.
    @Test
    public void testDeleteContact_withValidId_deletesSuccessfully() {
        Contact c = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(c);
        service.deleteContact(ID);
        assertThrows(NoSuchElementException.class, () -> service.getContact(ID));
    }

    // This test checks that deleting an invalid contact ID throws an error.
    @Test
    public void testDeleteContact_withInvalidId_throwsException() {
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("bad_id"));
    }

    // This test checks that updating a contact modifies its values correctly.
    @Test
    public void testUpdateContact_withValidData_updatesSuccessfully() {
        Contact c = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(c);
        service.updateContact(ID, "Mike", "Smith", "9998887777", "New St");
        Contact updated = service.getContact(ID);
        assertEquals("Mike", updated.getFirstName());
    }

    // This test checks that the contact returned is a new instance.
    @Test
    public void testGetContact_returnsNewInstance() {
        Contact c = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(c);
        Contact fetched = service.getContact(ID);
        assertNotSame(c, fetched);
    }
}
