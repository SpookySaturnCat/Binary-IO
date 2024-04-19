/**
 * File: Person.java 
 * Class: CSCI 1302 
 * Author: Taylor O'Neal, Seraphina Morrison 
 * Created on: April 19th, 2024 
 * Last Modified: April 19th, 2024 
 * Description:
 */

public class Person implements Comparable<Object> {
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;
	
	Person() {
		
	}
	
	Person(int age, String name, String address, int zipCode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
	}
	
	@Override 
	public int compareTo(Object o) {
		if (this.getSalary() > ((Person) o).getSalary()) {
			return 1;
		} else if (this.getSalary() < ((Person) o).getSalary()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		return String.format("%d %s %s %d $%,.2f%n", getAge(), getName(), getAddress(), getZipCode(), getSalary());
		
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
