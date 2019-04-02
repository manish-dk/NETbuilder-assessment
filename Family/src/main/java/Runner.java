
public class Runner {

	public static void main(String[] args) {
		Family fam = new Family();
		fam.male("Mike");
		fam.male("Lina");
		System.out.println(fam.setParent("George", "Mike"));
//		fam.setParent("George", "Mike");
		fam.setParent("George", "Lina");
//		fam.setParent("Lina", "James");
		
		
		
//		System.out.println(fam.getParents("George")[1]);
		System.out.println(fam.getParents("George")[0]);
//		System.out.println(fam.setParent("Lina", "George"));
//		System.out.println(fam.setParent("James", "George"));
		System.out.println(fam.isFemale("Lina"));
//		
//		Family fam = new Family();
//		fam.setParent("Vera", "George");
//		fam.setParent("Vera", "Vanessa");
//		fam.female("Vanessa");

	}

}
