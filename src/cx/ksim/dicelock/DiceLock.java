package cx.ksim.dicelock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DiceLock {

	public static void main(String[] args) {

		// TODO: Introduce command line arguments / .env file / config file
		var wordCount = 6;
		var wordList = "wordlist.txt";
		var wordSep = " ";

		try {
			for ( int i = 0; i < wordCount; i++ ) {
				var path = (DiceLock.class.getClassLoader().getResourceAsStream( wordList ));
				var br = new BufferedReader( new InputStreamReader( path ) );

				SecureRandom secureRandom = SecureRandom.getInstanceStrong();
				StringBuilder stringBuilder = new StringBuilder();

				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );
				stringBuilder.append( secureRandom.nextInt( 1, 7 ) );

				var num = stringBuilder.toString();
				var c = br.lines().filter( line -> line.startsWith( num ) ).findFirst().get();

				System.out.print( c.split( "\t" )[1] + wordSep );
			}
			// TODO: Better error handling
//		} catch ( IOException e ) {
//			e.printStackTrace();
		} catch ( NoSuchAlgorithmException e ) {
			e.printStackTrace();
//		} catch ( URISyntaxException e ) {
//			System.err.println( "IO" );
//			e.printStackTrace();
		}

	}

}
