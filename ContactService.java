package contact;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null)
            throw new IllegalArgumentException("Contact cannot be null");
        if (contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact ID must be unique");
        contacts.put(contact.getContactId(), new Contact(
            contact.getContactId(),
            contact.getFirstName(),
            contact.getLastName(),
            contact.getPhone(),
            contact.getAddress()));
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new NoSuchElementException("Contact not found");
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId))
            throw new NoSuchElementException("Contact not found");

        Contact existing = contacts.get(contactId);
        existing.setFirstName(firstName);
        existing.setLastName(lastName);
        existing.setPhone(phone);
        existing.setAddress(address);
    }

    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new NoSuchElementException("Contact not found");

        Contact c = contacts.get(contactId);
        return new Contact(c.getContactId(), c.getFirstName(), c.getLastName(), c.getPhone(), c.getAddress());
    }
}
