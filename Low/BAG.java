package com.gs.low;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
public class BAG{
	public static boolean pass() {
		String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" },{ "Sachin", "12" } };
		String [][] s2 = { { "Janie", "-66" },{ "Janie", "0" },{ "Gina", "-88" },{ "Bobby", "0" },{ "Gina", "44" },{ "Bobby", "0" },{ "Bobby", "-6" } };
		String [][] s3 = { { "Janie", "66" },{ "Janie", "0" },{ "Gina", "88" },{ "bobby", "lp" },{ "Gina", "44" },{ "Bobby", "0" },{ "Bobby", "6" } };
		String [][] s4  = {};
		String [][] s5 = {null};
		String [][] s6 = null;
		boolean pass = true;
		pass = pass & bestAvgGrade(s1) == 84;
		pass = pass & bestAvgGrade(s2) == -2;
		pass = pass & bestAvgGrade(s3) == 66;
		return pass;
	}

	private static Double bestAvgGrade(String[][] scores) {
		if(scores==null || scores.length==0)	return 0.0;

		Map<String, Double> scoreMap= 
				Arrays.stream(scores)
				.filter(e -> e!=null && e.length!=0 && e[0]!=null)
				.filter(e-> {
					try{ 
						Double.parseDouble(e[1]);
						return true;
					}
					catch(NumberFormatException exc){  
						return false;  
					}
				})
				.collect(
						Collectors.groupingBy(e -> e[0].toLowerCase(),
								Collectors.averagingInt(eachScore -> Integer.parseInt(eachScore[1])))
						);
		System.out.println(scoreMap);
		
		return scoreMap.size()==0 ? 0 : scoreMap.entrySet().stream()
				.map(e -> e.getValue())
				.max((i1, i2) -> Double.compare(i1, i2))
				.get();

	}
	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}
}