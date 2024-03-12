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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.BranchBo;
import lk.ijse.Dto.BranchDto;
import lk.ijse.Dto.Tm.BranchTm;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class BranchFormController implements Initializable {
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
    @FXML
    private TableView<BranchTm> tblBranch;
    private String Status;

    BranchBo branchBo = (BranchBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.BRANCH);
    ObservableList<BranchTm>obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllBranch();
        setCellValueFactory();
        setBranchId();
        tableListener();
    }

    private void tableListener() {
        tblBranch.getSelectionModel()
                .selectedItemProperty()
                .addListener((observableValue, BranchTm, t1) -> {
                    txtBranchId.setText(t1.getId());
                    txtBranchName.setText(t1.getName());
                    txtBranchAddress.setText(String.valueOf(t1.getAddress()));
                    txtBranchContact.setText(String.valueOf(t1.getContact()));
                });
    }

    private void setCellValueFactory() {
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBranchAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colBranchContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colBranchStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAllBranch() {
        try {
            ArrayList<BranchDto> branchDtos = branchBo.getAll();

            for (BranchDto branchDto :branchDtos) {
                obList.add(new BranchTm(branchDto.getId(),branchDto.getName(),branchDto.getAddress(),branchDto.getContact(),branchDto.getStatus()));
            }
            tblBranch.setItems(obList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = txtBranchId.getText();
        String name = txtBranchName.getText();
        String address = txtBranchAddress.getText();
        int contact = Integer.parseInt(txtBranchContact.getText());
        String status = Status;

        boolean isValidate = validateBranch( name, address, contact);
        if (isValidate){
            boolean isAdd = branchBo.AddBranch(new BranchDto(id, name, address, contact, status));
            if (isAdd){
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Added Successfully !!").show();
                refreshTable();
                clearField();
            }else{
                new Alert(Alert.AlertType.WARNING, "Something went wrong !!").show();
            }
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtBranchId.getText();
        String name = txtBranchName.getText();
        String address = txtBranchAddress.getText();
        int contact = Integer.parseInt(txtBranchContact.getText());
        String status = Status;

        boolean isValidate = validateBranch( name, address, contact);
        if (isValidate){
            boolean isUpdate = branchBo.UpdateBranch(new BranchDto(id,name,address,contact,status));

            if (isUpdate){
                new Alert(Alert.AlertType.INFORMATION ,"Branch Updated!!").show();
                refreshTable();
                clearField();
            }else {
                new Alert(Alert.AlertType.ERROR, "Try Again !!").show();
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
       String id = txtBranchId.getText();

       boolean isDelete = branchBo.deleteBranch(id);
       if (isDelete){
           new Alert(Alert.AlertType.INFORMATION ,"Branch Delete SuccessFully !!").show();
           refreshTable();
           clearField();
       }else {
           new Alert(Alert.AlertType.ERROR,"Try Again !!").show();
       }
    }

    public void rdbtnOpenOnAction(ActionEvent actionEvent) {
        if(rdbtnOpen.isSelected()){
            Status="Open";
        }else{
            Status="Close";
        }
        System.out.println(Status);
    }

    public void rdBtnCloseOnAction(ActionEvent actionEvent) {
        if(rdBtnClose.isSelected()){
            Status="Close";
        }else{
            Status="Open";
        }
        System.out.println(Status);
    }


    private void setBranchId() {
        String BranchId = branchBo.generateNewBookID();

        if (BranchId == null) {
            txtBranchId.setText("BR000001");
        } else {
            String[] split = BranchId.split("[B][R]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newID = String.format("BR%06d", lastDigits);
            txtBranchId.setText(newID);
        }
    }
    private void clearField(){
        txtBranchId.clear();
        txtBranchName.clear();
        txtBranchAddress.clear();
        txtBranchContact.clear();
    }
    private void refreshTable() {
        obList.clear();
        setBranchId();
        loadAllBranch();
    }
    private boolean validateBranch(String name,String address,int contact){
        boolean isValidateName = Pattern.matches("[A-Za-z]+",name);
        if (!isValidateName){
            new Alert(Alert.AlertType.ERROR,"Invalid Branch Name !!").show();
            return false;
        }
        boolean isValidateAddress = Pattern.matches("[A-Za-z]+",address);
        if (!isValidateAddress){
            new Alert(Alert.AlertType.ERROR,"Invalid Branch Address !!").show();
            return false;
        }
        boolean isValidateContact = Pattern.matches("[0-9]{9,}",String.valueOf(contact));
        if (!isValidateContact){
            new Alert(Alert.AlertType.ERROR,"Invalid Branch Contact !!").show();
            return false;
        }
        return true;
    }
}
