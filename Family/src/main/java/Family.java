import java.util.ArrayList;
import java.util.Collections;

public class Family {
	private ArrayList<Person> members = new ArrayList<Person>();
	
	public boolean male(String name) {
		Person p = getPerson(name);
		ArrayList<Person> partners = getPartners(p);
		if(isFemale(name)) return false;
		for(Person partner:partners) {
			if(partner.getGender().equals("male")) return false;
		}
		for(Person partner:partners) {
			partner.setGender("female");
		}
		if (!checkMember(name)) {
			p.setGender("male");
			members.add(p);
		}
		else p.setGender("male");
		return true;
	}
	
	public boolean female(String name) {
		Person p = getPerson(name);
		ArrayList<Person> partners = getPartners(p);
		if(isMale(name)) return false;
		for(Person partner:partners) {
			if(partner.getGender().equals("female")) return false;
		}
		for(Person partner:partners) {
			partner.setGender("male");
		}
		if (!checkMember(name)) {
			p.setGender("female");
			members.add(p);
		}
		else p.setGender("female");
		return true;
	}
	
	public boolean isMale(String name) {
		for(Person member:members) {
			if(member.getName().equals(name) ) {
				if(member.getGender().equals("male")) return true;
			}
		}
		return false;
	}
	
	public boolean isFemale(String name) {
		for(Person member:members) {
			if(member.getName().equals(name) ) {
				if(member.getGender().equals("female")) return true;
			}
		}
		return false;
	}
	
	public boolean setParent(String childName, String parentName) {
		ArrayList<Person> desc = new ArrayList<Person>();
		Person parent = getPerson(parentName);
		Person child = getPerson(childName);
		if(getDescendants(child,desc).contains(parent) || child.getName().equals(parent.getName())) return false;
		for(Person par:child.getParents() ) {
			if(par==null) continue;
			if(par.getGender().equals(parent.getGender()) && !par.getName().equals(parentName) && !par.getGender().equals("")) return false;
			if(par.getGender().equals("female") && !par.getName().equals(parentName)) parent.setGender("male");
			if(par.getGender().equals("male") && !par.getName().equals(parentName)) parent.setGender("female");
		}
		
		if(!checkMember(parentName)) members.add(parent);
		if(!checkMember(childName)) members.add(child);
		child.addParent(parent);
		parent.addChild(child);
		return true;
	}
	
	public String[] getParents(String name) {
		Person p = getPerson(name);
		String[] parents = new String[2];
		if(p.getParents()[1]==null) {
			parents[0]=p.getParents()[0].getName();
			return parents;
		}
		for(int i = 0; i<p.getParents()[0].getName().length() || i<p.getParents()[1].getName().length();i++) {
			if(p.getParents()[0].getName().charAt(i)<p.getParents()[1].getName().charAt(i)) {
				parents[0] = p.getParents()[0].getName();
				parents[1] = p.getParents()[1].getName();
				return parents;
			}
			else if(p.getParents()[0].getName().charAt(i)>p.getParents()[1].getName().charAt(i)) {
				parents[0] = p.getParents()[1].getName();
				parents[1] = p.getParents()[0].getName();
				return parents;
			}
		}
		return parents;
	}
	
	public String[] getChildren(String name) {
		Person p = getPerson(name);
		ArrayList<String> children = new ArrayList<String>();
		for(Person child:p.getChildren() ) {
			children.add(child.getName());
		}
		Collections.sort(children);
		String[] ch = new String[children.size()];
		ch = children.toArray(ch);
		return ch;
	}
	
	public Person getPerson(String name) {
		for(Person member:members) {
			if(member.getName().equals(name) ) return member;
		}
		Person p = new Person(name);
		return p;
	}
	
	public boolean checkMember(String name) {
		for(Person member:members) {
			if(member.getName().equals(name) ) return true;
		}
		return false;
	}
	
	public ArrayList<Person> getDescendants(Person p, ArrayList<Person> descendants) {
		if(p.getChildren() == null) return descendants;
		for(Person child:p.getChildren() ) {
			descendants.add(child);
			getDescendants(child,descendants);
		}
		return descendants;
	}
	
	public ArrayList<Person> getPartners(Person p) {
		ArrayList<Person> partners = new ArrayList<Person>();
		for(Person child:p.getChildren()) {
			if(!child.getParents()[0].getName().equals(p.getName())) {
			partners.add(child.getParents()[0]);
			}
			if(child.getParents()[1]==null) continue;
			if(!child.getParents()[1].getName().equals(p.getName())) {
			partners.add(child.getParents()[1]);
			}
		}
		return partners;
	}


}
