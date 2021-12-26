package com.gs.high;

public class ShortestDistanceBetweenTwoWords {
	private static final String document;

	static {
		final StringBuffer sb = new StringBuffer();
		sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
		sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
		sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

		document = sb.toString();
	}

	public static double shortestDistance(final String document, String word1, String word2) {

		String[] words = document.toLowerCase().split("[., ]");
		double word1Count = 0;
		double word2Count = 0;
		int indexCount = 0;
		double shortDist = Double.MAX_VALUE;
		
		for(String word : words){

			if(word.equalsIgnoreCase(word1))
				word1Count = indexCount + word.length()/2d;
			else if(word.equalsIgnoreCase(word2))
				word2Count = indexCount + word.length()/2d;
		
			if(word1Count > 0 && word2Count > 0)
				shortDist = Math.min(shortDist , Math.abs(word2Count - word1Count));

			indexCount += word.length()+1;
		}
		System.out.println(String.format("Word1 : %s, word2: %s, distance: %s", word1, word2, shortDist));

		return shortDist;
	}

	public static boolean pass() {
		return shortestDistance(document, "and", "graphic") == 6d &&
				shortestDistance(document, "transfer", "it") == 14d &&
				shortestDistance(document, "Design", "filler") == 25d;
	}

	public static void main(String[] args) {
		if (pass()) System.out.println("Pass");
		else System.out.println("Some Fail");
	}

}