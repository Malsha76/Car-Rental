package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake
 */

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;
    public TextField txtUsername ;
    public TextField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUsername.getText();
        String pw = txtPassword.getText();

        if(pw.equals("123") && userName.equals("admin")){
            Navigation.navigate(Routes.DASHBOARD, pane);
        } else{
            new Alert(Alert.AlertType.ERROR, " Login Error ! \n Recheck Username And Password !").show();
        }
    }
}
