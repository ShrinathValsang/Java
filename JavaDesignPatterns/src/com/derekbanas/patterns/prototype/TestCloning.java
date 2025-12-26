package com.derekbanas.patterns.prototype;

public class TestCloning {

	public static void main(String[] args) {
		AnimalFactory animalFactory = new AnimalFactory();
		Sheep sally = new Sheep();
		
		//Animal anotherSally = animalFactory.getClone(sally);
		Sheep anotherSally = (Sheep) animalFactory.getClone(sally);
		System.out.println(sally);
		System.out.println(anotherSally);

		System.out.println("sally hashCode " + System.identityHashCode(sally));
		System.out.println("anotherSally hashCode " + System.identityHashCode(anotherSally));
		
	}

}
