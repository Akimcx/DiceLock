package cx.ksim.dicelock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DiceLock {

	public static void main(String[] args) {

		// TODO: Introduce command line arguments / .env file / config file
		var wordCount = 6;
		var wordList = "wordlist.txt";
		var wordSep = " ";

		try {
			var path = Paths.get( wordList );
			for ( int i = 0; i < wordCount; i++ ) {

				SecureRandom secureRandom = SecureRandom.getInstanceStrong();
				StringBuilder stringBuilder = new StringBuilder();

				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );

				var num = stringBuilder.toString();
				var c = Files.lines( path ).filter( t -> t.startsWith( num ) ).findAny().get();
				System.out.print( c.split( "\t" )[1] + wordSep );
			}
			// TODO: Better error handling
		} catch ( IOException e ) {
			e.printStackTrace();
		} catch ( NoSuchAlgorithmException e ) {
			e.printStackTrace();
		}

	}

}
