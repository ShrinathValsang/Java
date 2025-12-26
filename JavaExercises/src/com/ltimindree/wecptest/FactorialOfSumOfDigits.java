package com.ltimindree.wecptest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//WeCP LTIMindTree -- 28 September 2024 
public class FactorialOfSumOfDigits {

	public static void main(String[] args) {
		List<Integer> integers = List.of(122, 8975, 101100, 11111, 19864471 );
		System.out.println(getFactorialSum(5));
		List<Integer> specials = specialNumbers(integers);
		System.out.println("Special numbers -- " + specials);
	}

	private static List<Integer> specialNumbers(List<Integer> integers) {
		List<Integer> specialNums = new ArrayList<>();
		
		for (int i = 0; i < integers.size(); i++) {
			int num = integers.get(i);
			
			int finalSum = getFinalSum(num);
			System.out.printf("\nfinalSum for %d is %d", num, finalSum);
			
			int factorialSum = getFactorialSum(finalSum);
			System.out.printf("\nfactorialSum for %d is %d\n", num, factorialSum);
			
			// if num's all digits are in the factorialSum sum, then its a 
			// special number
			Set<Integer> numDigits = getAllDigitsOfNum(num);
			Set<Integer> factorialSumDigits = getAllDigitsOfNum(factorialSum);
			
			if (factorialSumDigits.containsAll(numDigits)) 
				specialNums.add(num);
		}
		
		return specialNums;
	}

	private static Set<Integer> getAllDigitsOfNum(int num) {
		Set<Integer> set = new HashSet<>();
		
		while (num > 0) {
			set.add(num % 10);
			num = num / 10;
		}
		
		return set;
	}

	private static int getFinalSum(int num) {
		int finalSum = 0;
		
		while (num > 0) {
			finalSum += num % 10;
			num /= 10;
		}
		
		return finalSum > 10 ? getFinalSum(finalSum) : finalSum;
	}

	private static int getFactorialSum(int num) {
		int factorialSum = 1;
		while (num > 0) {
			factorialSum *= num--;
		}
		
		return factorialSum;
	}

}
