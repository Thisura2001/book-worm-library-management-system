package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class BranchFormController {
    @FXML
    private AnchorPane rootBranch;

    @FXML
    private TableColumn<?, ?> colBranchAddress;

    @FXML
    private TableColumn<?, ?> colBranchContact;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colBranchStatus;

    @FXML
    private RadioButton rdBtnClose;

    @FXML
    private RadioButton rdbtnOpen;

    @FXML
    private JFXTextField txtBranchAddress;

    @FXML
    private JFXTextField txtBranchContact;

    @FXML
    private JFXTextField txtBranchId;

    @FXML
    private JFXTextField txtBranchName;
    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
