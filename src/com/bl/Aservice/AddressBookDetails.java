package com.bl.Aservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bl.Amodel.Person;

public class AddressBookDetails {
    private List<Person> addressBook = new ArrayList<Person>();
    private HashSet<String> contactsByCity = new HashSet<String>();
    private HashSet<String> contactsByState = new HashSet<String>();
    private ArrayList<String> city = new ArrayList<String>();
    private ArrayList<String> state = new ArrayList<String>();


    public void addContactToAddressBook(Person contact) {
        Predicate<Person> isPresent = n -> {
            return n.equals(contact);
        };
        if (!addressBook.stream().anyMatch(isPresent))
            addressBook.add(contact);
        else
            System.out.println("Duplicate Contact! Enter a new Contact or Edit exixting Contact");
    }

    public void displayAddressBook() {
        addressBook.stream().forEach(n -> System.out.println(n.toString()));
    }

    public void editContact(String fullName) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        for (Person contact : addressBook) {
            if (fullName.toUpperCase().equals((contact.getFullName()).toUpperCase())) {
                System.out.println("Choose What to EDIT : ");
                System.out.println("1. Address");
                System.out.println("2. City");
                System.out.println("3. State");
                System.out.println("4. Zip");
                System.out.println("5. Phone Number");
                System.out.println("6. Email");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new address:");
                        sc.nextLine();
                        contact.setAddress(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new city:");
                        contact.setCity(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new state:");
                        sc.nextLine();
                        contact.setState(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new zip:");
                        contact.setZip(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Enter new phone number:");
                        contact.setPhoneNumber(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter new email:");
                        contact.setEmail(sc.next());
                        break;
                    default:
                        System.out.println("INVALID choice");
                }
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Contact doesn't Exist");

    }

    public void deleteContact(String name) {
        boolean flag = true;
        for (Person contact : addressBook) {
            if (name.toUpperCase().equals((contact.getFullName()).toUpperCase())) {
                addressBook.remove(contact);
                flag = false;
            }
        }
        if (flag)
            System.out.println("Contact doesn't Exist");
        else
            System.out.println("Contact Deleted");
    }

    public Person createContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = sc.next();
        System.out.println("Enter Last Name:");
        String lastName = sc.next();
        System.out.println("Enter address:");
        sc.nextLine();
        String address = sc.nextLine();
        System.out.println("Enter city:");
        String city = sc.next();
        System.out.println("Enter state:");
        sc.nextLine();
        String state = sc.nextLine();
        System.out.println("Enter zip:");
        int zip = sc.nextInt();
        System.out.println("Enter phone No.:");
        String phoneNumber = sc.next();
        System.out.println("Enter email address:");
        String email = sc.next();
        return (new Person(firstName, lastName, address, city, state, zip, phoneNumber, email));
    }

    public HashSet<String> searchContactByCity(String city) {
        contactsByCity.clear();
        addressBook.stream().filter(contact -> city.equalsIgnoreCase(contact.getCity())).forEach(contact -> contactsByCity.add(contact.getFullName()));
        return contactsByCity;
    }

    public HashSet<String> searchContactByState(String state) {
        contactsByState.clear();
        addressBook.stream().filter(contact -> state.equalsIgnoreCase(contact.getState())).forEach(contact -> contactsByState.add(contact.getFullName()));
        return contactsByState;
    }

    public void addressBookOperations(String addressBookNameToOperate) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Entered Address Book -> " + addressBookNameToOperate);
            boolean operate = true;
        while (operate) {
            System.out.println("1. Create and Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Sort Address Book");
            System.out.println("5. Display Address Book");
            System.out.println("6. Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContactToAddressBook(createContact());
                    break;
                case 2:
                    System.out.println("Enter the Full Name : ");
                    String fullName = sc.nextLine();
                    editContact(fullName);
                    break;
                case 3:
                    System.out.println("Enter the Full Name : ");
                    String name = sc.nextLine();
                    deleteContact(name);
                    break;
                case 4:
                    sortByPerson();
                    break;
                case 5:
                    displayAddressBook();
                    break;
                case 6:
                    operate = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void sortByPerson() {
        addressBook = addressBook = addressBook.stream().sorted(Comparator.comparing(Person::getFullName)).collect(Collectors.toList());
        System.out.println("Address Book sorted by Person Name");
    }

    public ArrayList<String> getCities() {
        addressBook.stream().forEach(contact -> {
            city.add(contact.getCity());
        });
        return city;
    }

    public ArrayList<String> getStates() {
        addressBook.stream().forEach(contact -> {
            state.add(contact.getState());
        });
        return state;
    }
    }
