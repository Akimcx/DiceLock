package cx.ksim.dicelock.core;

public record DiceLockOptions(
		int wordCount, String wordList, 
		String delimiter,boolean verbose,
		boolean shouldCapitalize ) {
	
	DiceLockOptions() {
		this(6,"/wordlist,txt");
	}	
	
	DiceLockOptions(int wordCount, String wordList) {
		this(wordCount, wordList, " ", false, true);
	}
}
