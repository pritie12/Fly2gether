package com.example.jetty_jersey.dao;
import java.util.Date;

public abstract class User {
	String id; // has to be unique
	String name;
	String surname;
	Date dateOfBirth;
	String email;
	String phoneNumber;
}
