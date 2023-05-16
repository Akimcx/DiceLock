package cx.ksim.dicelock;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiceLockTest {

	@ParameterizedTest(name = "Should generate {0} words.")
	@ValueSource(ints = { 3, 6, 9 })
	void generateWords(int count) {
		assertEquals( DiceLock.generateRandomWords( count, "/wordlist.txt", " " ).split( " " ).length, count );
	}

}
