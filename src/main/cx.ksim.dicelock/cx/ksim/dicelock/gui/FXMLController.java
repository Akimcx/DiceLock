package cx.ksim.dicelock.gui;

 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
 
public class FXMLController {
	@FXML private Button generatePassphraseBtn;
	@FXML private CheckBox shouldCapitalize;
	@FXML private TextField wordCount;
	@FXML private ChoiceBox<String> delimiter;
    
    @FXML
    private void generatePassphrase(ActionEvent event) {
    	System.out.println("CheckBox: " + shouldCapitalize.isSelected());
    	System.out.println("TextField: " + wordCount.getText());
    	System.out.println("Delimiter: " + delimiter.getValue());
    	System.out.println("Passphrase: ");
    	System.out.println("Passphrase: ");
    }

}