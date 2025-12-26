package com.hiramkamau.streams;

import java.math.BigDecimal;
import java.util.Comparator;

public class Mortality implements Comparable {
    private final String ageGroup;
    private final BigDecimal mortality;
    
    //Constructor and getters...
    
    public Mortality(String ageGroup, BigDecimal mortality) {
		super();
		this.ageGroup = ageGroup;
		this.mortality = mortality;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public BigDecimal getMortality() {
		return mortality;
	}

//	@Override
//    public int compareTo(Mortality other) {
//        return Comparator.comparing(Mortality::getMortality)
//            .compare(this, other);
//    }

	@Override
	public int compareTo(Object other) {
		if (other instanceof Mortality) {
			Mortality m = (Mortality) other;
			
			return Comparator.comparing(Mortality::getMortality).compare(this, m);
		}
		
		return 0;
	}
}
