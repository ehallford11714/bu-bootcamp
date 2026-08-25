import java.util.*; 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        contacts.put("Mike Smith", new Contact("Mike Smith", "+1 516 631 6361")); 
        contacts.put("John Apples", new Contact("John Apples", "+1 406 642 4263")); 
        contacts.put("Westing Miles", new Contact("Westing Miles", "+1 426 122 466"));
        contacts.put("Nigel Dawson", new Contact("Nigel Dawson  ", "+1 646 353 1353"));
        contacts.put("Clifton Bors", new Contact("Clifton Bors", "+1 617 555 0105"));
         contacts.put("Adam Lawson", new Contact("Adam Lawson", "+1 617 555 0105"));
 
        // Step 5: look up a contact
        System.out.println("Test contact: Mike Smith");
        Contact mikeSmith = contacts.get("Mike Smith"); 
        if (mikeSmith != null) {
            System.out.println("Found contact: " + mikeSmith.getName() + " | " + mikeSmith.getPhone());
        } else {
            System.out.println("Contact not found.");
        }

        // Check Test when contact is not found
        Contact unknownContact = contacts.get("Shriley Thompson");
        System.out.println("Test contact: Shriley Thompson");
        if (unknownContact != null) {
            System.out.println("Found contact: " + unknownContact.getName() + " | " + unknownContact.getPhone());
        } else {
            System.out.println("Contact not found.");
        }
        // Step 6: print sorted list 
        System.out.println(" === All Contacts ===  ");
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}
