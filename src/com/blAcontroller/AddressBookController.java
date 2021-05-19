package com.blAcontroller;

import com.bl.Amodel.Person;

public class AddressBookController {
 
	public static void main(String[] args) {
        System.out.println("  Welcome to the Address Book...!!! \n \n");
        Person contactPerson = new Person("Saket", "Jain", "Purana panna naka", "Chhatarpur", "MP",
                471001, 79874699, "saketj420@gmail.com");
        System.out.println(contactPerson.toString());
    }

	
	
}

