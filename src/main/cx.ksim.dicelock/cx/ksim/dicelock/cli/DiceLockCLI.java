package cx.ksim.dicelock.cli;

import java.util.concurrent.Callable;

import cx.ksim.dicelock.core.DiceLock;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
		name = "dicelock", version = "1.0",
		mixinStandardHelpOptions = true,
		description = "Generate a passphrase using the diceware method"
	)
public class DiceLockCLI implements Callable<Integer>{

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
	private String delimiter = " ";
	
	@Option(
			names = {"-w", "--words"},
			paramLabel = "WORDLIST", defaultValue = "wordlist.txt",
			description = "file to choose words from. Default to ${DEFAULT-VALUE}"
			)
	private String wordList = "/wordlist.txt";
	
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


	@Override
	public Integer call() throws Exception {
		System.out.println(DiceLock.generateRandomWords(null));
		return 0;
	}

}
