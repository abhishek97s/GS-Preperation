package com.gs.low;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;

class FirstNonRepeating {
	static Character findChar(String input){
		Optional<Character> result= input.chars()
				.mapToObj(s -> Character.toLowerCase((char)s))
				.collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
				.entrySet().stream()
				.filter(e -> e.getValue().equals(1L))
				.map(e -> e.getKey())
				.findFirst();
		return result.isPresent() ? result.get() : '0';  
	}

	public static void main(String[] args) {
		String input = "a Bhishek sharma";
		System.out.println(findChar(input));
	}
}