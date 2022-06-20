package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {
    @FXML
    public Button sendButton;
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;


    public void clickSend(ActionEvent actionEvent) {
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
            textField.requestFocus();
    }

    public void onEnterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
            textField.requestFocus();
        }
    }
}
