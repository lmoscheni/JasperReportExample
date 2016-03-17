package ar.com.leandro.reporteria;

public class Dog {

	private String name;
	private String owner;
	private String breed;

	public Dog(String name, String owner, String breed) {
		this.name = name;
		this.owner = owner;
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public String getBreed() {
		return breed;
	}
}
