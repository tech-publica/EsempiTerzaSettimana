package it.epicode.lambdas;

import java.util.List;

public class Persona {
	private String name;
	
	private List<String> bestFriendNames;
	
	public List<String> getBestFriendNames() {
		return bestFriendNames;
	}

	public Persona(String name) {
		this.name = name;
	}
	
	public Persona(String name, List<String> names) {
		this(name);
		this.bestFriendNames = names;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + "]";
	}

}
