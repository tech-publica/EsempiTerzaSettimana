package it.epicode.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsempiLambdaStreams {
	public static final Logger logger = LoggerFactory.getLogger(EsempiLambdaStreams.class);

	public static void main(String[] args) {

		logger.debug("main starting");
		logger.debug("main starting");
		Runnable r = new MyRunnable();
		Thread t1 = new Thread(r);

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world!");
			}
		});

//		Runnable y = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		};

		List<Persona> persone = new ArrayList<>();
		persone.add(new Persona("ciccio", Arrays.asList("pippo, pluto, paperino")));
		persone.add(new Persona("pippo", Arrays.asList("minnie, clarabella")));

		for (Persona persona : persone) {
			System.out.println(persona.getName());
		}

		persone.forEach(p -> {

			System.out.println(p);
		});

		Stream<String> ss = persone.stream().map(p -> p.getName());

		Stream<String> xs = persone.stream().filter(p -> p.getAge() >= 18).map(p -> p.getName());

		List<String> nomi = xs.collect(Collectors.toList());

		Stream<Persona> spm = persone.stream().filter(p -> p.getAge() >= 18);

		List<Persona> maggiorenni = spm.collect(Collectors.toList());

		List<String> nm = new ArrayList<>();
		for (Persona p : maggiorenni) {
			String nome = p.getName();
			if(nome.length() > 5 ) {
				nm.add(p.getName());
			}
			
		}

		List<String> nomiMaggiorenni = maggiorenni.stream().map(p -> p.getName())
				.filter(n -> n.length() > 5).collect(Collectors.toList());

		List<Integer> etaMaggiorenni = maggiorenni.stream().map(p -> p.getAge()).collect(Collectors.toList());

		Consumer<Persona> cp = new PersonaConsumer();
		persone.forEach(cp);

		Stream<String> res = persone.stream().flatMap(p -> p.getBestFriendNames().stream());
		res.forEach(s -> System.out.println(s));
	}

	public static <T> void myForEach(List<T> elements, Consumer<T> lambda) {
		for (T t : elements) {
			lambda.accept(t);
		}
	}

}
