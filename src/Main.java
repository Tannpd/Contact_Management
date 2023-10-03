

import Controller.Manager;

public class Main {
    public static void main(String[] args) {
        String mChon[] = {"Add a contact", "Display all contacts", "Delete a contact"};
        Manager manager = new Manager("Main Menu", mChon, "exit");
        manager.run();
    }
}
