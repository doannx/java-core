package vn.elca.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {
	String name;
	int age;
	String country;

	public Employee(String name, int age, String country) {
		this.name = name;
		this.age = age;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int compareTo(Employee o) {
		int result = 0;
		// compare [country] field
		result = this.country.compareTo(o.country);
		// compare [name] field
		if (result == 0) {
			result = this.name.compareTo(o.name);
		}
		// compare [age] field
		if (result == 0) {
			result = (this.age == o.age ? 0 : (this.age > o.age ? 1 : -1));
		}
		return result;
	}

	public static void main(String[] args) {
		List<Employee> lstE = new ArrayList<Employee>();
		lstE.add(new Employee("A", 15, "A"));
		lstE.add(new Employee("B", 20, "B"));
		lstE.add(new Employee("A", 15, "B"));
		lstE.add(new Employee("A", 16, "B"));
		Collections.sort(lstE);
		lstE.stream().forEach(
				e -> System.out.println(e.getCountry() + ":" + e.getName()
						+ ":" + e.getAge()));
	}
}
