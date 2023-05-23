module cx.ksim.dicelock.gui {
	requires cx.ksim.dicelock.core;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	exports cx.ksim.dicelock.gui;
	
	opens cx.ksim.dicelock.gui to javafx.fxml;
}