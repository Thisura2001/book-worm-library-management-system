package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.AdminBo;

import java.io.IOException;

public class RegisterFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    AdminBo adminBo = (AdminBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.ADMIN);
    public void btnRegisterOnAction(ActionEvent actionEvent) {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        boolean isValidate = adminBo.RegisterAdmin(userName, password);
        if (isValidate) {
           new Alert(Alert.AlertType.CONFIRMATION , "Register Successfully").showAndWait();
           navigate();
           clearFields();
        }else{
            new Alert(Alert.AlertType.ERROR , "Try Again").show();
        }
    }
    private void navigate(){
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/view/Login.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void clearFields() {
        txtPassword.setText("");
        txtUserName.setText("");
    }
}
