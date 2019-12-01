package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML public TextField textField;
    @FXML public javafx.scene.control.TextArea textArea;

    public void Enter(){
        textArea.appendText(textField.getText() + System.lineSeparator());
        textField.clear();
    }

    public void SetText(ActionEvent actionEvent) {Enter();}

    public void TextField(ActionEvent actionEvent) {Enter();}
}
