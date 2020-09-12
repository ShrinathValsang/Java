package com.generic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*

5 2
1 2 1 2 4

6 3
1 3 9 9 27 81

5 5
1 5 5 25 125

 */
public class NoOfTripletsGeometric {

    // Complete the countTriplets function below.
	// duplicates to be considered
    static long countTriplets(List<Long> arr, long r) {
    	long trips = 0;
    	for (int i = arr.size()-1; i >= 0; i--) {
    		
    	}
    	
    	return trips;
    }

	// duplicates are not considered here -- unique triplets
    static long countTriplets1(List<Long> arr, long r) {
    	long trips = 0;
    	Iterator<Long> it = arr.iterator();
    	
    	List<Long> list = new ArrayList<>();
    	while (it.hasNext()) {
    		Long l = it.next();
    		list.add(l);
    		
    		if (list.contains(l/r) && list.contains(l / (r * r))) {
    			trips++;
    		}
    	}
    	
    	return trips;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nr[0]);
        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
        bufferedReader.close();
//        bufferedWriter.close();
    }
}

