package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.UserBo;
import lk.ijse.Dto.Tm.UserTm;
import lk.ijse.Dto.UserDto;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

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

    @FXML
    private TableView<UserTm> tblUser;

    private String status;

    UserBo userBo = (UserBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.USER);
    ObservableList<UserTm> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllUsers();
        setCellValueFactory();
        setUserId();
        tableListener();
    }

    private void loadAllUsers() {
        try{
            List<UserDto>userDtos = userBo.getAll();
            for (UserDto userDto:userDtos){
                obList.add(new UserTm(userDto.getId(),userDto.getName(),userDto.getAddress(),userDto.getContact(),userDto.getGender()));
            }
            tblUser.setItems(obList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void tableListener() {
        tblUser.getSelectionModel()
                .selectedItemProperty()
                .addListener((observableValue, UserTm, t1) -> {
                    txtUserId.setText(t1.getId());
                    txtUserName.setText(t1.getName());
                    txtUserAddress.setText(String.valueOf(t1.getAddress()));
                    txtUserContact.setText(String.valueOf(t1.getContact()));
                });

    }

    private void setUserId() {
        String UserId = userBo.generateNewUserID();

        if (UserId == null) {
            txtUserId.setText("U000001");
        } else {
            String[] split = UserId.split("[U]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newID = String.format("U%06d", lastDigits);
            txtUserId.setText(newID);
        }

    }

    private void setCellValueFactory() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUserAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colUserContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colUserGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String name = txtUserName.getText();
        String address = txtUserAddress.getText();
        int contact = Integer.parseInt(txtUserContact.getText());
        String gender = status;

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setAddress(address);
        userDto.setContact(contact);
        userDto.setGender(gender);

        boolean isAdd = userBo.AddUser(userDto);
        if (isAdd){
            new Alert(Alert.AlertType.CONFIRMATION ,"User Saved !!").show();
            clearFields();
            refreshTable();
        }else {
            new Alert(Alert.AlertType.ERROR ,"Try Again !!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String name = txtUserName.getText();
        String address = txtUserAddress.getText();
        int contact = Integer.parseInt(txtUserContact.getText());
        String gender = status;

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setAddress(address);
        userDto.setContact(contact);
        userDto.setGender(gender);

        boolean isUpdate = userBo.updateUser(userDto);
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION ,"User Updated !!").show();
            clearFields();
            refreshTable();
        } else {
            new Alert(Alert.AlertType.ERROR ,"Try Again !!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        boolean isDelete = userBo.deleteUser(id);
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION ,"User Deleted !!").show();
            clearFields();
            refreshTable();
        } else {
            new Alert(Alert.AlertType.ERROR ,"Try Again !!").show();
        }
    }
    private void clearFields(){
        txtUserId.clear();
        txtUserName.clear();
        txtUserAddress.clear();
        txtUserContact.clear();
    }
    private void refreshTable(){
        obList.clear();
        loadAllUsers();
    }

    public void rbBtnMaleOnAction(ActionEvent actionEvent) {
        if(rdbtnfemale.isSelected()){
            status="Female";
        }else{
            status="Male";
        }
        System.out.println(status);
    }

    public void rbBtnFemaleOnAction(ActionEvent actionEvent) {
        if (rdbtnMail.isSelected()){
            status = "Male";
        }else {
            status = "Female";
        }
    }
}
