import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FamilyTest {
	
	@Test
	public void familyTest() {
		Family fam = new Family();
		fam.setParent("Vera", "George");
		fam.setParent("Vera", "Vanessa");
		fam.female("Vanessa");

		assertEquals(false, fam.female("George"));
		assertEquals(true, fam.isMale("George"));
	}
	
	@Test
	public void famTest() {
		Family fam = new Family();
		assertEquals(true, fam.setParent("Frank", "Morgan"));
		assertEquals(true, fam.setParent("Frank", "Dylan"));
		assertEquals(true, fam.male("Dylan"));
		assertEquals(true, fam.setParent("Joy","Frank"));
		assertEquals(true, fam.male("Frank"));
		assertEquals(false, fam.male("Morgan"));
		assertEquals(true, fam.setParent("July","Morgan"));
		assertEquals(false, fam.isMale("Joy") );
		assertEquals(false, fam.isFemale("Joy") );
		for(String child:fam.getChildren("Morgan")) System.out.print(child +" ");
		System.out.println();
		assertEquals(true, fam.setParent("Jennifer","Morgan"));
		assertEquals(false, fam.setParent("Morgan","Frank"));
		
		for(String child:fam.getChildren("Morgan")) System.out.print(child +" ");
		System.out.println();
		for(String child:fam.getChildren("Dylan")) System.out.print(child +" ");
		System.out.println();
		for(String child:fam.getParents("Frank")) System.out.print(child +" ");
		
	}

}
