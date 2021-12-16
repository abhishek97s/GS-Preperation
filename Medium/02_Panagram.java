import java.io.*;
import java.util.*;

/**
 * Pangram FInder
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing
 *
 */
class Solution {

  private static class PanagramDetector {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public String findMissingLetters(String sentence) {
	HashMap <Character, Boolean> charCheck = new HashMap<>();
	for(char c : sentence.toLowerCase().toCharArray()) {
		charCheck.put(c, true);
	}
	StringBuilder sb = new StringBuilder();
	for(char c = 'a'; c <= 'z'; c++) {
		if(!charCheck.containsKey(c)) {
			sb.append(c);
		}
	}
	return sb.toString();
  }

  }

  public static void main(String[] args) {
  PanagramDetector pd = new PanagramDetector();
  boolean success = true;

  success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
  success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

  if (success) {
    System.out.println("Pass ");
  } else {
    System.out.println("Failed");
  }
  }
}