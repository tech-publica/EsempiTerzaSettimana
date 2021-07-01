package it.epicode.lambdas;

import java.util.function.Consumer;

public class PersonaConsumer implements Consumer<Persona>{

	@Override
	public void accept(Persona t) {
		System.out.println("hello I am " + t.getName());
		
	}
   
}
