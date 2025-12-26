package com.oracle.questionsAndExercises;


interface Flyer {
	public default String identifyMyself() {
		return "I am able to fly!";
	}
}

interface Mythical {
	public default String identifyMyself() {
		return "I am a mythical creature!";
	}
}

class Horse {

//	public String identifyMyself() {
//		return "I am a horse.";
//	}
}


// Inheritance rule no. 1 - Instance methods are preferred over interface default methods
public class Pegasus implements Flyer, Mythical {
	Iterable iterable;
	
	public String identifyMyself() {
		System.out.println(Flyer.super.identifyMyself());
		return Mythical.super.identifyMyself();
		
		//return "I am a Pegasus!";
	}

	public static void main(String[] args) {
		Flyer peg = new Pegasus();
		System.out.print(peg.identifyMyself());
		
		
	}

}
