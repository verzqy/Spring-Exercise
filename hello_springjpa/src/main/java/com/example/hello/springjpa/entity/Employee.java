package com.example.hello.springjpa.entity;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	public Employee() {}
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long empId;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
	@Column(name="gender", nullable = false)
    private String gender;
    @Column(name="dob")
    private Date dob;
//  @OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
//  private Set<OfficeLocation> officeLocations;
    
    
    public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}


}
