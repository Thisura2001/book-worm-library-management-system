package lk.ijse.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.BookBo;
import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Bo.Custom.UserBo;
import lk.ijse.Dto.BookDto;
import lk.ijse.Dto.UserDto;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GetNewBooksController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbBook;

    @FXML
    private JFXComboBox<String> cmbUser;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNewTransactionId();
        getAllBooks();
        getAllUsers();
    }

    private void getAllUsers() {
        ObservableList<String>obList = FXCollections.observableArrayList();
        try {
            ArrayList<UserDto>dtos = (ArrayList<UserDto>) userBo.getAll();
            for (UserDto userDto:dtos){
                obList.add(userDto.getId());
            }
            cmbUser.setItems(obList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getAllBooks() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<BookDto> idList = bookBo.getAll();

            for (BookDto dto : idList) {
                obList.add(dto.getId());
            }

            cmbBook.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setNewTransactionId() {
        String reservationID = bookDetailsBo.generateNewTranceactionID();

        if (reservationID == null) {
            txttrId.setText("TRS000001");
        } else {
            String[] split = reservationID.split("[T][R][S]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newID = String.format("RI%06d", lastDigits);
            txttrId.setText(newID);
        }
    }

    @FXML
    void btnGetOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookOnAction(ActionEvent event) {
       String id = String.valueOf(cmbBook.getValue());
        try {
            BookDto bookDto = bookBo.searchBook(id);
            txtAvailability.setText(String.valueOf(bookDto.getAvailability()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbUserOnAction(ActionEvent event) {
        String id = cmbUser.getValue();

        try {
            UserDto userDto = userBo.searchUser(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void datepickerOnAction(ActionEvent event) {

    }
}
