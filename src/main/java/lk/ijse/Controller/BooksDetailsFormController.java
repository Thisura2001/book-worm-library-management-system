package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.BookBo;
import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Dto.BookDetailsDto;
import lk.ijse.Dto.BookDto;
import lk.ijse.Dto.Tm.BookDetailTm;
import lk.ijse.Dto.Tm.BookTm;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BooksDetailsFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnMarkAsReturend;

    @FXML
    private JFXButton btnViewUnReturn;

    @FXML
    private JFXButton btngetNewBooks;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colAvailability;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> coltitle;

    @FXML
    private TableColumn<?, ?> coltrId;

    @FXML
    private TableView<BookTm> tblBook;

    @FXML
    private TableView<BookDetailTm> tblBookDetails;

    BookBo bookBo = (BookBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BOOK);
    BookDetailsBo bookDetailsBo = (BookDetailsBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BookDetails);
    ObservableList<BookTm> obList = FXCollections.observableArrayList();
    ObservableList<BookDetailTm> obDetails = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBooks();
        setBookSellValueFactory();
        getAllBookDetails();
        setBookDetailValueFactory();
    }

    private void setBookDetailValueFactory() {
        coltrId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("user"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("book"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void getAllBookDetails() {
        try {
            List<BookDetailsDto> all = bookDetailsBo.getAllBookDetails();
            for (BookDetailsDto bookDetailsDto : all) {
                obDetails.add(new BookDetailTm(bookDetailsDto.getId(), bookDetailsDto.getUserDto().getId(), bookDetailsDto.getDate(), bookDetailsDto.getBookDto().getTitle(), bookDetailsDto.getStatus()));
            }
            tblBookDetails.setItems(obDetails);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setBookSellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
    }

    private void loadBooks() {
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

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            BookDetailTm bookDetailTm = tblBookDetails.getSelectionModel().getSelectedItem();
                Boolean isDelete = bookDetailsBo.deleteDetails(bookDetailTm.getId());
            if (isDelete) {
                refreshTable();
                new Alert(Alert.AlertType.CONFIRMATION,"Delete SuccessFully !!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Try Again").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnGetNewBooksOnAction(ActionEvent event) throws IOException {
        try {
            Stage stage = new Stage();
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/getNewBooks.fxml"));
            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    refreshTable();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnMarkAsReturendOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewUnReturnOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/unreturned.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    private void refreshTable() {
        obDetails.clear();
        getAllBookDetails();
    }
}
