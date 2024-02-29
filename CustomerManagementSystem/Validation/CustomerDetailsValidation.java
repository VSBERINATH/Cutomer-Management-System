package com.CustomerManagementSystem.Validation;

import com.CustomerManagementSystem.entities.CommunicationAddress;
import com.CustomerManagementSystem.entities.PermanentAddress;

import jakarta.validation.constraints.NotNull;

public class CustomerDetailsValidation {

	
	@NotNull(message ="thappuu")
	private String firstName;
	@NotNull
	private String lastName;
	private	String nickName;
	
	private char sex;
	
	private int age;
	private String qualification;
	
	
	private  PermanentAddress pa;
	
	
	private CommunicationAddress ca;
	
	private String notes;

	public CustomerDetailsValidation() {
		// TODO Auto-generated constructor stub
	}
	public CustomerDetailsValidation(@NotNull String firstName, @NotNull String lastName, String nickName, char sex,
			int age, String qualification, PermanentAddress pa, CommunicationAddress ca, String notes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.qualification = qualification;
		this.pa = pa;
		this.ca = ca;
		this.notes = notes;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public PermanentAddress getPa() {
		return pa;
	}
	public void setPa(PermanentAddress pa) {
		this.pa = pa;
	}
	public CommunicationAddress getCa() {
		return ca;
	}
	public void setCa(CommunicationAddress ca) {
		this.ca = ca;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
