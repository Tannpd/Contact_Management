package Controller;

import Common.Library;
import Model.Contact;
import View.Menu;
import java.util.ArrayList;

public class Manager extends Menu {

    ArrayList<Contact> ct = new ArrayList<>();
    Library l;

    public Manager(String td, String[] mc, String exit) {
        super(td, mc, exit);
        l = new Library();
        ct = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createContact(ct);
                break;
            case 2:
                printAllContact(ct);
                break;
            case 3:
                deleteContactd(ct);
                break;
        }
    }

   public void createContact(ArrayList<Contact> ct) {
        int contactId = generateID();
        System.out.print("Enter first name: ");
        String firstName = l.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = l.checkInputString();
        System.out.print("Enter group: ");
        String group = l.checkInputString();
        System.out.print("Enter address: ");
        String address = l.checkInputString();
        System.out.print("Enter phone: ");
        String phone = l.checkInputPhone();
        ct.add(new Contact(contactId, firstName +" "+ lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    //allow user display all contact
    public void printAllContact(ArrayList<Contact> ct) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print infomation of contact from first to last list contact
        for (Contact contact : ct) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    //allow user delete contact
    public void deleteContactd(ArrayList<Contact> ct) {
        System.out.print("Enter id: ");
        int idDelete = l.checkInputInt();
        Contact contactDelete = getContactById(ct, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            ct.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public Contact getContactById(ArrayList<Contact> ct, int idDelete) {
        for (Contact contact : ct) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
    
    public int generateID() {
        int id = 0;
        if (ct.size() == 0) {
            return 1;
        } else {

            for (Contact s : ct) {
                if (s.getContactId()== ct.size()) {
                    id = s.getContactId() + 1;
                }
            }
        }
        return id;
    }
}
