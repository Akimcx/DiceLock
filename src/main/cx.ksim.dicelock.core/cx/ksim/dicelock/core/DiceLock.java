package cx.ksim.dicelock.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DiceLock{

	public static String generateRandomWords(DiceLockOptions options) {
		final var words = new String[options.wordCount()];
		for ( int i = 0; i < words.length; i++ ) {

			var path = (DiceLock.class.getResourceAsStream( options.wordList() ));
			try ( var br = new BufferedReader( new InputStreamReader( path ) ) ) {
				SecureRandom secureRandom = SecureRandom.getInstanceStrong();
				StringBuilder stringBuilder = new StringBuilder();

				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );

				var num = stringBuilder.toString();
				assert (num.length() == 5);
				words[i] = br.lines()
						.filter( line -> line.startsWith( num ) )
						.findFirst()
						.get()
						.split("\t")[1];
				
				if(options.shouldCapitalize()) words[i] = capitalize(words[i]);
				if(options.verbose()) System.out.printf("Grabbed %s word: %s\n", toOrdinal(1+i), words[i]);
				
			} catch ( NoSuchAlgorithmException e ) {
				e.printStackTrace();
			} catch ( IOException e1 ) {
				e1.printStackTrace();
			}
		}
		return String.join(options.delimiter(), words);
	}
	
	private static String capitalize(String str) {
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	private static String toOrdinal(int number) {
	    if (number < 0) {
	        throw new IllegalArgumentException("Number must be non-negative");
	    }
	    
	    if (number == 0) {
	        return "zeroth";
	    }
	    
	    if (number % 100 >= 11 && number % 100 <= 13) {
	        return number + "th";
	    }
	    
	    return switch (number % 10) {
	        case 1 -> number + "st";
	        case 2 -> number + "nd";
	        case 3 -> number + "rd";
	        default -> number + "th";
	    };
	}

}
