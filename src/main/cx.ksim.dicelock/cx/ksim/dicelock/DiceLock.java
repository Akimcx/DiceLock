package cx.ksim.dicelock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class DiceLock {

	public static void main(String[] args) {

		// TODO: Introduce command line arguments / .env file / config file
		// TODO: Better error handling

		var wordCount = 6;
		var wordList = "/wordlist.txt";
		var wordSep = " ";

		var c = generateRandomWords( wordCount, wordList, wordSep );
		System.out.println( c );
	}

	public static String generateRandomWords(int wordCount, String wordList, String wordSep) {
		final var words = new String[wordCount];
		for ( int i = 0; i < wordCount; i++ ) {

			var path = (DiceLock.class.getResourceAsStream( wordList ));
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
				words[i] = br.lines().filter( line -> line.startsWith( num ) ).findFirst().get();
			} catch ( NoSuchAlgorithmException e ) {
				e.printStackTrace();
			} catch ( IOException e1 ) {
				e1.printStackTrace();
			}
		}
		// TODO: Task Failed Successfully
		// It actually print the exact wordCount, but give the whole line
		return Arrays.toString( words );
	}

}
