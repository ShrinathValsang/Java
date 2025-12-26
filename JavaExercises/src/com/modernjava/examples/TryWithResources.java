package com.modernjava.examples;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class TryWithResources {

	public static void main(String[] args) {
		//Java 8
		Reader inputStream = new StringReader("Dont cut any corners");
		BufferedReader bufferedReader = new BufferedReader(inputStream);
		
		//try (BufferedReader bufferedReader1 = bufferedReader)
		try (bufferedReader) {
			System.out.println(bufferedReader.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//Java 9
		Reader reader2 = new StringReader("Hang in there");
		
		try(BufferedReader bufferedReader3 = new BufferedReader(reader2);) {
			System.out.println(bufferedReader3.readLine());;
		} catch (Exception e) {
			
		}
		
		// 113 type inference for lambdas in Java 11
//		List<Instructor> instructors = ConsumerExample.getInstructors();
		
		var instructors = ConsumerExample.getInstructors();
		Predicate<Instructor> p = (var i) -> i.getYrsOfExp() > 10;
		instructors.forEach(i -> {
			if (p.test(i)) {
				System.out.println(i);
			}
		});
		
		BiFunction<Integer, Integer, Integer> sum = (var x, var y) -> x + y;
		System.out.println(sum.apply(4, 89));
		
		
		
		
	}

}
