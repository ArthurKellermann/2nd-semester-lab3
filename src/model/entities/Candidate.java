package model.entities;

public class Candidate {
	private String name, politicalParty;
	private int age, numberOfVotes;

	public Candidate() {

	}

	public Candidate(String name, String politicalParty, int age, int numberOfVotes) {
		this.name = name;
		this.politicalParty = politicalParty;
		this.age = age;
		this.numberOfVotes = numberOfVotes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

}
