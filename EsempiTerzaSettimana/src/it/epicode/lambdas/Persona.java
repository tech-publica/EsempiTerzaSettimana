package it.epicode.lambdas;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Persona {
	private String name;
	private int age;
	public static final Logger logger =
			LoggerFactory.getLogger(EsempiLambdaStreams.class);
	

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
		logger.debug("chiamato getName");
		return name;
	}
	public int getAge() {
		logger.debug("chiamato getAge");
		return age;
	}
	@Override
	public String toString() {
		return "Persona [name=" + name + "]";
	}

}
