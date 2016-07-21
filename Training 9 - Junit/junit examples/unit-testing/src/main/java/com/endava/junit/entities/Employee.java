package com.endava.junit.entities;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private Date dateOfEmployment;
	private int rank;
	private String position;

	public Employee(int id, String name, Date dateOfEmployment, int rank,
			String position) {
		this.id = id;
		this.name = name;
		this.dateOfEmployment = dateOfEmployment;
		this.rank = rank;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfEmployment="
				+ dateOfEmployment + ", rank=" + rank + ", position="
				+ position + "]";
	}

}
