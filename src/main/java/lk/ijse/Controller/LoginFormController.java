package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.LoginBo;
import lk.ijse.Dto.AdminDto;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private RadioButton btnRadio;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtShowPassword;
    @FXML
    private JFXButton btnLogin;
    private boolean passClicked;
    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.LOGIN);

    public void btnRadioOnAction(ActionEvent actionEvent) {
        if (!passClicked) {
            passClicked = true;
            String passwordText = txtPassword.getText();
            txtShowPassword.setText(passwordText);
            txtPassword.setVisible(false);
            txtShowPassword.setVisible(true);
        } else {
            passClicked = false;
            txtPassword.setVisible(true);
            txtShowPassword.setVisible(false);
        }

    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();


            AdminDto adminDto = new AdminDto(userName, password);

            boolean isValid = loginBo.validUser(adminDto);

            if (isValid) {
              LoadDashBoard();
            }else {

                new Alert(Alert.AlertType.ERROR, "Invalid user name or password :( !!!").show();
            }
        }



    public void btnResgisterOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Register.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setTitle("book worm");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
        btnLogin.fire();
    }

    public void txtUsernameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
    private void LoadDashBoard() throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setTitle("book worm");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
