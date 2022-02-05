package sample;
import java.util.ArrayList;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

public class ContactManager {
    private static int currentContactId = 1;
    private static int numContacts;
    private static ArrayList<Contact> contactArrayList = new ArrayList<>();

    public static boolean addContact (String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, MyDate birthday, String notes)
    {
        Contact temp = new Contact(currentContactId, firstName, lastName, homePhone, workPhone, homeAddress, email, birthday, notes);
        contactArrayList.add(temp);
        numContacts++;
        currentContactId++;
        return true;
    }

    public static ArrayList<Contact> getContacts() { return contactArrayList;
    }

    private static int findContact(int contactId)
    {
        for (int i = 0; i < numContacts; i++)
        {
            if (contactArrayList.get(i).getContactId() == contactId)
                return i;
        }
        return -1;
    }

    private static int findContactByKeyWord(String keyWord)
    {
        for (int i = 0; i < numContacts; i++)
        {
            if (contactArrayList.get(i).getFirstName().equals(keyWord)) { return i; }
            else if (contactArrayList.get(i).getLastName().equals(keyWord)) { return i; }
            else if (contactArrayList.get(i).getFullName().equals(keyWord)) { return i; }
        }
        return -1;
    }

    public static boolean contactExists(int contactId)
    {
        int loc = findContact(contactId);
        if (loc == -1) { return false; }
        return true;
    }

    public static boolean contactExistsByKeyWord(String keyWord)
    {
        int loc = findContactByKeyWord(keyWord);
        if (loc == -1) { return false; }
        return true;
    }

    public static Contact getContact(int contactId)
    {
        int loc = findContact(contactId);
        if (loc == -1) { return null; }
        return contactArrayList.get(loc);
    }

    public static Contact getContactByKeyWord(String keyWord)
    {
        int loc = findContactByKeyWord(keyWord);
        if (loc == -1) { return null; }
        return contactArrayList.get(loc);
    }

    public static ArrayList<Contact> getAllContactsByKeyWord(String keyWord)
    {
        ArrayList<Contact> matchContacts = new ArrayList<>();
        for (int i = 0; i < numContacts; i++)
        {
            if(contactArrayList.get(i).getFullName().equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
            if(contactArrayList.get(i).getFirstName().equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
            if(contactArrayList.get(i).getLastName().equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
            if(contactArrayList.get(i).getHomeAddress().city.equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
            if(contactArrayList.get(i).getHomeAddress().country.equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
            if(contactArrayList.get(i).getHomeAddress().province.equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
            if(contactArrayList.get(i).getHomeAddress().postalCode.equals(keyWord)) {matchContacts.add(contactArrayList.get(i));}
        }
        return matchContacts;
    }

    public static boolean deleteContact(int contactId)
    {
        int loc = findContact(contactId);
        if (loc == -1) { return false; }
        contactArrayList.remove(loc);
        numContacts--;
        return true;
    }
    public static String getContactInfo(int contactId)
    {
        int loc = findContact(contactId);
        if (loc == -1) { return "There is no contact with id " + contactId + "."; }
        return contactArrayList.get(loc).toString();
    }
    public static String getContactList()
    {
        String s = "Contact List:";
        for (int i = 0; i < numContacts; i++)
        {
            s += "\n" + contactArrayList.get(i).getContactId() + " \t " + contactArrayList.get(i).getFirstName() + " \t " +contactArrayList.get(i).getLastName();
        }
        return s;
    }
}
