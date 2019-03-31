import java.util.ArrayList;

public class Person {
	private String name;
	private String gender = "";
	private ArrayList<Person> children = new ArrayList<Person>();
	private Person[] parents = new Person[2];
	
	public Person(String name) {
		this.name = name;
	}
	
	
	public ArrayList<Person> getChildren() {
		return children;
	}


	public void addChild(Person child) {
		children.add(child);
	}


	public Person[] getParents() {
		return parents;
	}


	public void addParent(Person person) {
		if(parents[0]==null) parents[0] = person;
		else if(parents[1]==null) parents[1] = person;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
