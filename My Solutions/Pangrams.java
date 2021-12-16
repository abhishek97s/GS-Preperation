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
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
class Solution {

  private static class PanagramDetector {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public String findMissingLetters(String sentence) {
    
    StringBuilder b = new StringBuilder();
    sentence.chars().mapToObj(c ->Character.toLowerCase((char)c))
               .distinct().sorted().forEach(b::append);

    StringBuilder sb = new StringBuilder();
    for(char c = 'a'; c <= 'z'; c++) {
      if(b.indexOf(Character.toString(c))<0) {
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
