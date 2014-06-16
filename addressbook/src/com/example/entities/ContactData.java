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
}