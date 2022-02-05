package sample;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private Address homeAddress;
    private String email;
    private MyDate birthday;
    private String notes;
    private String fullName;

    // constructor
    public Contact(int contactId, String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, MyDate birthday, String notes) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = homeAddress;
        this.email = email;
        this.birthday = birthday;
        this.notes = notes;
        this.fullName = getFullName();
    }

    // getters
    public int getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getHomePhone() { return homePhone; }
    public String getWorkPhone() { return workPhone; }
    public Address getHomeAddress() { return homeAddress; }
    public String getEmail() { return email; }
    public MyDate getBirthday() { return birthday; }
    public String getNotes() { return notes; }
    public String getFullName() { return firstName + " " + lastName; }

    // setters
    public void setContactId(int contactId) { this.contactId = contactId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }
    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }
    public void setHomeAddress(Address homeAddress) { this.homeAddress = homeAddress; }
    public void setEmail(String email) { this.email = email; }
    public void setBirthday(MyDate birthday) { this.birthday = birthday; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        String s = "";
        s += "Contact ID: " + contactId;
        s += "\nFull Name: " + firstName + " " + lastName;
        s += "\nHome Phone: " + homePhone;
        s += "\nWork Phone: " + workPhone;
        s += "\nHome Address: " + homeAddress;
        s += "\nEmail: " + email;
        s += "\nBirthday: " + birthday;
        s += "\nNotes: " + notes;
        return s;
    }
}
