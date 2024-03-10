package lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.UserBo;
import lk.ijse.Dto.Tm.unReturnedTm;
import lk.ijse.Dto.UserDto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UnreturnedController implements Initializable {
    @FXML
    private TableColumn<?, ?> ColUserAddress;

    @FXML
    private TableColumn<?, ?> colUserContact;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableView<unReturnedTm> tblUnReturned;
    @FXML
    private AnchorPane root;


    UserBo userBo = (UserBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.USER);
    ObservableList<unReturnedTm> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllUnReturnedUsers();
        setcellValueFactory();
    }

    private void setcellValueFactory() {
       colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
       colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
       ColUserAddress.setCellValueFactory(new PropertyValueFactory<>("userAddress"));
       colUserContact.setCellValueFactory(new PropertyValueFactory<>("userContact"));
    }

    private void getAllUnReturnedUsers() {
        try {
            ArrayList<UserDto>userDtos = userBo.getAllUnReturnedUsers();
            for (UserDto userDto : userDtos) {
                obList.add(new unReturnedTm(userDto.getId(),userDto.getName(),userDto.getAddress(),userDto.getContact()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        tblUnReturned.setItems(obList);
    }
}
