package cx.ksim.dicelock.core;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiceLockTest {
	
	@ParameterizedTest(name = "Should generate {0} words.")
	@ValueSource(ints = { 3, 6, 9 })
	void generateWords(int count) {
		var options = new DiceLockOptions(count,"/wordlist.txt"," ",false,false);
		assertEquals( DiceLock.generateRandomWords( options ).split( " " ).length, count );
	}

}
