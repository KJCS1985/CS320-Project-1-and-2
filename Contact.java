package contact;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Contact ID must be non-null and no longer than 10 characters.");
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("First name must be non-null and no longer than 10 characters.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Last name must be non-null and no longer than 10 characters.");
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Phone must be exactly 10 numeric digits.");
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Address must be non-null and no longer than 30 characters.");
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return contactId.equals(other.contactId) &&
               firstName.equals(other.firstName) &&
               lastName.equals(other.lastName) &&
               phone.equals(other.phone) &&
               address.equals(other.address);
    }
}
