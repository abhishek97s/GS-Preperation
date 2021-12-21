package com.gs.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ApacheLog {

	/**
	 * Given a log file, return IP address(es) which accesses the site most often.
	 */

	public static String findTopIpaddress(String[] lines) {
		// Your code goes here
		HashMap<String, Integer> map = new HashMap<>();

		for(String log : lines){
			String[] arr = log.split(" ");
			map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
		}

		String maxEntry= 
				map.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

		return maxEntry;
	}



	public static void main(String[] args) {

		String lines[] = new String[] {
				"10.0.0.1 - log entry 1 11",
				"10.0.0.1 - log entry 2 213",
		"10.0.0.2 - log entry 133132" };
		String result = findTopIpaddress(lines);

		if (result.equals("10.0.0.1")) {
			System.out.println("Test passed");

		} else {
			System.out.println("Test failed");

		}  

	}

}