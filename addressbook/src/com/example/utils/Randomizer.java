package com.example.utils;

import java.util.Random;

public class Randomizer {
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	public static String generateRandomPhone() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "" + rnd.nextInt() * 10;
		}
	}

	public static String selectMonth() {
		String[] month = new String[] { "January", "February", "March",
				"April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int b = (int) (Math.random() * 12);
		String mon = month[b];
		System.out.println(mon);
		return mon;
	}

	public static String selectDay() {
		Random r = new Random();
		int a = r.nextInt(30) + 2;
		String day = String.valueOf(a);
		System.out.println(day);
		return day;
	}

	public static String selectYear() {
		int c = (int) (1970 + Math.random() * 43);
		String year = String.valueOf(c);
		System.out.println(year);
		return year;
	}
}
