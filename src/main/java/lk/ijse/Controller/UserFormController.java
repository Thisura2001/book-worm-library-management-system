package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class UserFormController {

    @FXML
    private AnchorPane rootUser;

    @FXML
    private TableColumn<?, ?> colUserAddress;

    @FXML
    private TableColumn<?, ?> colUserContact;

    @FXML
    private TableColumn<?, ?> colUserGender;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private RadioButton rdbtnMail;

    @FXML
    private RadioButton rdbtnfemale;

    @FXML
    private JFXTextField txtUserAddress;

    @FXML
    private JFXTextField txtUserContact;

    @FXML
    private JFXTextField txtUserId;

    @FXML
    private JFXTextField txtUserName;
    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
