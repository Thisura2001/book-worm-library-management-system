package lk.ijse.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.BookBo;
import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Bo.Custom.UserBo;

public class GetNewBooksController {

    @FXML
    private JFXComboBox<?> cmbBook;

    @FXML
    private JFXComboBox<?> cmbUser;

    @FXML
    private DatePicker datepicker;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAvailability;

    @FXML
    private JFXTextField txttrId;

    UserBo userBo = (UserBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.USER);
    BookBo bookBo = (BookBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BOOK);
    BookDetailsBo bookDetailsBo = (BookDetailsBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BookDetails);

    @FXML
    void btnGetOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookOnAction(ActionEvent event) {

    }

    @FXML
    void cmbUserOnAction(ActionEvent event) {

    }

    @FXML
    void datepickerOnAction(ActionEvent event) {

    }
}
