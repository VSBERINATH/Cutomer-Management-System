package com.CustomerManagementSystem.entities;




import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="details")

public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "FirstNAme is mandatory")
	private String firstName;
	@NotBlank(message = "lastname is mandatory")
	private String lastName;
	private	String nickName;

	private char sex;
	
	@Min(value = 18)
	private int age;
	@NotBlank(message = "qualification is mandatory")
	private String qualification;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "PHouseno")
	private  PermanentAddress pa;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "CHouseno")
	@Autowired
	private CommunicationAddress ca;
	
	@NotBlank(message = "notes is mandatory")
	private String notes;
	
	public Customer() {
		
	}
	public Customer(String firstName, String lastName, String nickName, char sex, int age, String qualification,
			PermanentAddress pa, CommunicationAddress ca, String notes) {
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
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", sex=" + sex
				+ ", age=" + age + ", qualification=" + qualification + ", pa=" + pa + ", ca=" + ca + ", notes=" + notes
				+ "]";
	}
	
	
	
}
