package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.BookBo;
import lk.ijse.Dto.BookDto;
import lk.ijse.Dto.Tm.BookTm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookFormController implements Initializable {
    @FXML
    private TableColumn<?, ?> colBookAuthor;

    @FXML
    private TableColumn<?, ?> colBookAvailability;

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private TableColumn<?, ?> colbookId;

    @FXML
    private AnchorPane rootBook;

    @FXML
    private TableView<BookTm> tblBook;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private TextField txtAvailability;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtBookTitle;

    BookBo bookBo = (BookBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BOOK);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colbookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
    }

    private void getAll() {
        ObservableList<BookTm> obList = FXCollections.observableArrayList();
        try {
            List<BookDto> all = bookBo.getAll();

            for (BookDto bookDto : all) {
                obList.add(new BookTm(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getAvailability()));
            }
            tblBook.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = txtBookId.getText();
        String title = txtBookTitle.getText();
        String author = txtAuthor.getText();
        int availability = Integer.parseInt(txtAvailability.getText());

        boolean isAdd = bookBo.AddBook(new BookDto(id, title, author, availability));
        if (isAdd) {
            new Alert(Alert.AlertType.CONFIRMATION, "Book Added").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Book Not Added").show();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtBookId.getText();
        String title = txtBookTitle.getText();
        String author = txtAuthor.getText();
        int availability = Integer.parseInt(txtAvailability.getText());

        boolean isUpdate = bookBo.updateBook(new BookDto(id, title, author, availability));
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION, "Book Updated").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Book Not Updated").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
