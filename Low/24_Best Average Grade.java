package com.gs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.
class Student {
	int count;
	double av;

	public Student(double score) {
		this.count = 1;
		this.av = score;
	}

	public Student(double score, int count) {
		this.count = count;
		this.av = score;
	}

}

class L24BestAvGrades {

	public static Double bestAvgGrade(String[][] scores) {
		HashMap<String, Student> marksheet = new HashMap<>();
		for (String[] score : scores) {
			if (marksheet.containsKey(score[0])) {
				marksheet.replace(score[0], new Student(
						(marksheet.get(score[0]).av * marksheet.get(score[0]).count + Double.parseDouble(score[1]))
								/ (marksheet.get(score[0]).count + 1),
						marksheet.get(score[0]).count));
			} else {
				marksheet.put(score[0], new Student(Double.parseDouble(score[1])));
			}
		}

		double max = 0;
		for (Student s : marksheet.values()) {
			if (s.av > max) {
				max = s.av;
			}
		}
		System.out.println(max);
		return max;

	}

	public static boolean pass() {
		String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };

		return bestAvgGrade(s1) == 84;
	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}
}
