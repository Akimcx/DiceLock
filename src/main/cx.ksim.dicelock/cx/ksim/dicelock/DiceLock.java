package cx.ksim.dicelock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
		name = "dicelock", version = "1.0",
		mixinStandardHelpOptions = true,
		description = "Generate a passphrase using the diceware method"
	)
public class DiceLock implements Callable<Integer>{

	@Option(
			names = {"-n", "--num"},
			paramLabel = "NUM", defaultValue = "6",
			description = "passphrase word count. Default ${DEFAULT-VALUE}"
		)
    private int wordCount = 6;
	
	@Option(
			names = {"-d", "--delimiter"},
			paramLabel = "DELIMITER", defaultValue = " ",
			description = "separate word by DELIMITER. Default to a space character"
		)
	private String wordSep = " ";
	
	@Option(
			names = {"-c", "--caps"},
			negatable = true, defaultValue = "true",
			fallbackValue = "true", description = "capitalize words. This is the default"
		)
	private boolean shoudlCapitalize = true;
	
	@Option(names = {"-v", "--verbose"}, description = "be verbose")
	private boolean verbose = false;

	
	public static void main(String[] args) {
        int exitCode = new CommandLine(new DiceLock()).execute(args);
        System.exit(exitCode);
	}

	public String generateRandomWords(int wordCount, String wordList, String wordSep) {
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
				words[i] = br.lines()
						.filter( line -> line.startsWith( num ) )
						.findFirst()
						.get()
						.split("\t")[1];
				if(shoudlCapitalize) words[i] = capitalize(words[i]);
				if (verbose) System.out.printf("Grabbed %s word: %s\n", toOrdinal(1+i), words[i]);
			} catch ( NoSuchAlgorithmException e ) {
				e.printStackTrace();
			} catch ( IOException e1 ) {
				e1.printStackTrace();
			}
		}
		return String.join(wordSep, words);
	}
	
	private String capitalize(String str) {
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	private String toOrdinal(int number) {
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

	
	@Override
	public Integer call() throws Exception {
		// TODO: Introduce command line arguments / .env file / config file
		// TODO: Better error handling

		var wordList = "/wordlist.txt";

		var c = generateRandomWords( wordCount, wordList, wordSep );
		System.out.println( c );
		return 0;
	}

}
