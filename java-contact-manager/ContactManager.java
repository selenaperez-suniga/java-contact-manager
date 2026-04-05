// Java Contact Manager Project
// Author: Selena Holcomb

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the Java Contact Manager!");

        while (running) {
            printMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-6.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("==================================");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Update Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Exit");
        System.out.println("==================================");
    }

    private static void addContact() {
        System.out.println("--- Add Contact ---");

        String name = getNonEmptyInput("Enter name: ");
        String phone = getNonEmptyInput("Enter phone number: ");
        String email = getNonEmptyInput("Enter email: ");

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        System.out.println("--- View All Contacts ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void searchContact() {
        System.out.println("--- Search Contact ---");
        String searchName = getNonEmptyInput("Enter name to search: ").toLowerCase();

        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchName)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching contact found.");
        }
    }

    private static void updateContact() {
        System.out.println("--- Update Contact ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available to update.");
            return;
        }

        viewContacts();
        int index = getIntInput("Enter contact number to update: ") - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = contacts.get(index);

        String newName = getNonEmptyInput("Enter new name: ");
        String newPhone = getNonEmptyInput("Enter new phone number: ");
        String newEmail = getNonEmptyInput("Enter new email: ");

        contact.setName(newName);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        System.out.println("Contact updated successfully.");
    }

    private static void deleteContact() {
        System.out.println("--- Delete Contact ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available to delete.");
            return;
        }

        viewContacts();
        int index = getIntInput("Enter contact number to delete: ") - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact removedContact = contacts.remove(index);
        System.out.println("Deleted contact: " + removedContact.getName());
    }

    private static String getNonEmptyInput(String prompt) {
        String input;

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}