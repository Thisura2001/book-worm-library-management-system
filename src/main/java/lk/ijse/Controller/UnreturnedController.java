package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class UnreturnedController {
    @FXML
    private TableColumn<?, ?> ColUserAddress;

    @FXML
    private TableColumn<?, ?> colUserContact;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableView<?> tblUnReturned;

    public void btnbackOnAction(ActionEvent actionEvent) {
    }
}
