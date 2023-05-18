
module cx.ksim.dicelock {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	exports cx.ksim.dicelock.fx;
	opens cx.ksim.dicelock.fx to javafx.fxml;
}
