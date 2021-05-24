package com.bl.Amodel;

public class Person {
    public String firstName;
    public String lastName;
    public String area;
    public String city;
    public String state;
    public int pin;
    public int phoneNumber;
    public String email;

    public Person(String firstName, String lastName, String area, String city, String state, int pin,
            int phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
      
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPin() {
		return pin;
	}

    public void setpin(int nextInt) {

    }
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String toString() {
        return "Details of: " + firstName + " " + lastName + "\n" + "Area: " + area + "\n" + "City: " + city + "\n"
                + "State: " + state + "\n" + "Pin: " + pin + "\n" + "Phone Number: " + phoneNumber + "\n" + "Email: "
                + email;
    }


	    }
