module cx.ksim.dicelock {
	requires info.picocli;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;

	exports cx.ksim.dicelock.fx;

	opens cx.ksim.dicelock to info.picocli;
	opens cx.ksim.dicelock.fx to javafx.fxml;
}
