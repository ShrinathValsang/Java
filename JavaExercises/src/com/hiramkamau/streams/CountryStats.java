package com.hiramkamau.streams;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryStats {
    private final String country;
    private final String code;
    private final String year;
    private final Mortality underFive;
    private final Mortality seventyPlus;
    private final Mortality fiftyToSixtyNine;
    private final Mortality fiveToFourteen;
    private final Mortality fifteenToFourtyNine;
    
    //Constructor and getters...
    
    public CountryStats(String country, String code, String year, Mortality underFive, Mortality seventyPlus,
			Mortality fiftyToSixtyNine, Mortality fiveToFourteen, Mortality fifteenToFourtyNine) {
		super();
		this.country = country;
		this.code = code;
		this.year = year;
		this.underFive = underFive;
		this.seventyPlus = seventyPlus;
		this.fiftyToSixtyNine = fiftyToSixtyNine;
		this.fiveToFourteen = fiveToFourteen;
		this.fifteenToFourtyNine = fifteenToFourtyNine;
	}

	public String getCountry() {
		return country;
	}

	public String getCode() {
		return code;
	}

	public String getYear() {
		return year;
	}

	public Mortality getUnderFive() {
		return underFive;
	}

	public Mortality getSeventyPlus() {
		return seventyPlus;
	}

	public Mortality getFiftyToSixtyNine() {
		return fiftyToSixtyNine;
	}

	public Mortality getFiveToFourteen() {
		return fiveToFourteen;
	}

	public Mortality getFifteenToFourtyNine() {
		return fifteenToFourtyNine;
	}

//	public Mortality getHighest() {
//        Stream<Mortality> stream = Stream.of(
//            underFive,
//            fiveToFourteen,
//            fifteenToFourtyNine,
//            fiftyToSixtyNine,
//            seventyPlus
//        );
//        
//		/* Mortality highest = */ 
////        stream.collect(
////            collectingAndThen(
////                Collectors.maxBy(
////                    Comparator.comparing(
////                        Mortality::getMortality
////                    )
////                ),
////                m -> m.orElseThrow(
////                    RuntimeException::new
////                )
////            )
////        );
//        
//        return highest;
//    }
}
