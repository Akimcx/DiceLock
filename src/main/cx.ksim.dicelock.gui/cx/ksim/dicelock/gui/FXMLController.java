package cx.ksim.dicelock.gui;

import cx.ksim.dicelock.core.DiceLock;
import cx.ksim.dicelock.core.DiceLockOptions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
 
public class FXMLController {
	@FXML private TextField wordCount;
	@FXML private ChoiceBox<String> delimiter;
	@FXML private CheckBox shouldCapitalize;
	@FXML private TextField generatedPassphrase;
	@FXML private Button generatePassphraseBtn;
    
    @FXML
    private void generatePassphrase(ActionEvent event) {
    	System.out.println("CheckBox: " + shouldCapitalize.isSelected());
    	System.out.println("TextField: " + wordCount.getText());
    	System.out.println("Delimiter: " + delimiter.getValue());
    	generatedPassphrase.setText(DiceLock.generateRandomWords(
    			new DiceLockOptions(Integer.parseInt(wordCount.getText(),10), "/wordlist.txt", " ", false,!shouldCapitalize.isSelected())));
    }

}