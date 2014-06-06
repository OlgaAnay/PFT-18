package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String mail1;
	public String mail2;
	public String day;
	public String month;
	public String year;
	public String newGroup;
	public String address2;
	public String phone2;

	public ContactData() {
	
	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", home=" + home + ", mobile="
				+ mobile + ", work=" + work + ", mail1=" + mail1 + ", mail2="
				+ mail2 + ", day=" + day + ", month=" + month + ", year="
				+ year + ", newGroup=" + newGroup + ", address2=" + address2
				+ ", phone2=" + phone2 + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}

}