package lk.ijse.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {

    @FXML
    private AnchorPane MainRoot;

    @FXML
    private Label lblDateTop;

    @FXML
    private Label lbltimeTop;

    @FXML
    private AnchorPane root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lbltimeTop.setText(LocalTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();

        lblDateTop.setText(java.time.LocalDate.now().toString());
    }

    @FXML
    void btnLogOut(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setTitle("book worm");
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    @FXML
    void btnManageBraches(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/branch.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnManageTranceAction(ActionEvent event) {

    }

    @FXML
    void btnManageUsers(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/user.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnmanageBook(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/book.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void loadWindow(AnchorPane anchorPane) {
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }
}
