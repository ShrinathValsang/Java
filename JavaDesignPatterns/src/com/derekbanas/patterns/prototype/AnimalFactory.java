package com.derekbanas.patterns.prototype;

public class AnimalFactory {
	Animal getClone(Animal sample) {
		return sample.makeCopy();
	}

}
