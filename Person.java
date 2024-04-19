
public class Person implements Comparable<Object>{
	private int age;
	private String name = "";
	private String address = "";
	private int zip;
	private double salary;
	
	public Person() {
		setAge(27);
		setName("Rhea Ripley");
		setAddress("123 Hot Bitches Ln.");
		setZip(31313);
		setSalary(100000000);
	}
	
	public Person (int age, String name, String address, int zip, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZip(zip);
		setSalary(salary);
	}
	
	public String toString() {
		return String.format("%d %s %s %d $%,.2f%n"
				, getAge(), getName(), getAddress(), getZip(), getSalary());
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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
	
}
