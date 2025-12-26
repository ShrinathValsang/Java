package com.modernjava.examples;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

import java.util.List;

public class SwitchExpressionsExample {

	public static void main(String[] args) {
		String month = "APRIL";
		String quarter = "";
		
//		switch(month) {
//			case "JANUARY":
//				quarter = "FIRST QUARTER"; break;
//			case "FEBRUARY":
//				quarter = "FIRST QUARTER"; break;
//			case "MARCH":
//				quarter = "FIRST QUARTER"; break;
//			case "APRIL":
//				quarter = "SECOND QUARTER"; break;
//			case "JULY":
//				quarter = "THIRD QUARTER"; break;
//			case "SEPTEMBER":
//				quarter = "FOURTH QUARTER"; break;
//			default:
//				quarter = "UNKNOWN";
//		}
		/*
		quarter = switch(month) {
			case "JANUARY", "FEBRUARY", "MARCH" -> "FIRST QUARTER";
			case "APRIL" -> "SECOND QUARTER";
			case "JULY" -> "THIRD QUARTER";	
			case "SEPTEMBER" -> "FOURTH QUARTER";
			default -> "UNKNOWN";
		};
		
		List<String> months = List.of("FEBRUARY", "MARCH", "AUGUST", "DECEMBER", "APRIL", "JULY", "SEPTEMBER");
		//months.stream().forEach(s -> System.out.println(switch(s)));
		
		System.out.println(quarter);
		*/
		String month1 = "JANUARY";
		quarter = switch(month1) {
			case "JANUARY", "FEBRUARY", "MARCH" -> {
				var leap_year = LocalDate.now().isLeapYear();
				yield (leap_year ? "FIRST QUARTER - LEAP YEAR" : "FIRST QUARTER");
			}
			case "APRIL" -> "SECOND QUARTER";
			case "JULY" -> "THIRD QUARTER";	
			case "SEPTEMBER" -> "FOURTH QUARTER";
			default -> "UNKNOWN QUARTER";
		};
		System.out.println(quarter);
		
		// TEXT BLOCKS -- JAVA 13
		String s1 = """
				hello world
				using 
				text blocks !""";
		System.out.println(s1);
		
		String phrase = """
				{
					employee : "Mike"
					employeeId : "12001"
					employeeType : "FULL-TIME"
				}
				""";
		System.out.println(phrase);
		
		String html = """
				<html>
					<body>
						<p>"Java Programming"<p>
					</body>
				</html>
				""";
		System.out.println(html);
		
		String st2 = s1.concat(html);
		System.out.println(st2);
		
	}

}
