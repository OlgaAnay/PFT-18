package com.example.entities;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String mail1;
	private String mail2;
	private String day;
	private String month;
	private String year;
	private String newGroup;
	private String address2;
	private String phone2;
	private String id;

	public ContactData() {
	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + "," +
							" lastname=" + lastname	+ "," +
							" address=" + address + "," +
							" home=" + home + "," +
							" mobile=" + mobile + "," +
							" work=" + work + "," +
							" mail1=" + mail1 + "," +
							" mail2=" + mail2 + "," +
							" day=" + day + ", " +
							" month=" + month + "," +
							" year=" + year + "," +
							" newGroup=" + newGroup + ", " +
							" address2=" + address2 + "," +
							" phone2=" + phone2 + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getMail1() {
		return mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getNewGroup() {
		return newGroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
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
		return this.lastname.toLowerCase().compareTo(
				other.lastname.toLowerCase());
	}

	public ContactData withId(String id) {
		this.id = id;
		return this;
	}
	
	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withMail1(String mail1) {
		this.mail1 = mail1;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withMail2(String mail2) {
		this.mail2 = mail2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}

	public ContactData withMonth(String month) {
		this.month = month;
		return this;
	}

	public ContactData withDay(String day) {
		this.day = day;
		return this;
	}

	public ContactData withYear(String year) {
		this.year = year;
		return this;
	}

	public ContactData withNewGroup(String newGroup) {
		this.newGroup = newGroup;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setNewGroup(String newGroup) {
		this.newGroup = newGroup;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
}