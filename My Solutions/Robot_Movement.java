package com.gs.high;

import java.util.Arrays;

public class Robot_Movement {
	public static Integer[] walk( String path ) {

		int x = 0, y = 0;
		for(char c : path.toCharArray()) {
			switch(c) {
			case 'U': y+=1;
			break;
			case 'D': y-=1;
			break;
			case 'R': x+=1;
			break;
			case 'L': x-=1;
			break;
			}
		}
		return new Integer[] {x, y};
	}

	public static boolean isEqual(Integer[] a, Integer[] b) {
		return Arrays.equals(a, b);
	}

	public static boolean pass() {
		boolean res = true;

		{
			String test = "UUU";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{0, 3});
		}

		{
			String test = "ULDR";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{0, 0});
		}

		{
			String test = "ULLLDUDUURLRLR";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{-2, 2});
		}

		{
			String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
			Integer[] result = walk(test);
			res &= isEqual(result, new Integer[]{1, 1});
		}

		return res;
	}

	public static void main(String[] args) {
		if(pass()){
			System.out.println("Pass");
		} else {
			System.out.println("Test failures");
		}
	}
}
