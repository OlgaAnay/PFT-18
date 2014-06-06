package com.example.tests;

import com.example.fw.ApplicationManager;

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
	protected static ApplicationManager app;

	public ContactData() {
	
	}
	public ContactData(String firstname, String lastname, String address,  String  home, String mobile
			, String work, String mail1, String  mail2
			, String day, String month, String year
			, String newGroup, String address2, String phone2) {
		this.firstname = "aaa";
		this.lastname = "Testing";
		this.home = "Spb";
		this.mobile = "1235678901";
		this.mail1 = "2@d.d";
		this.address2 = "123";
		this.address = "234";
		this.mail2 = "3@h.r";
		this.phone2 = "09876543212";
		this.work = "Work777";
		
		this.month = app.getContactHelper().selectMonth(app);
		this.day = app.getContactHelper().selectDay(app);
		this.year = app.getContactHelper().selectYear(app);
		
		this.newGroup = app.getContactHelper().selectNewGroup(app);
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