package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.model.PackageModel;
import lk.ijse.vehicle_rental.to.Packages;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class PackageFormController {



    public TextField txtPacId;
    public TextField txtPacName;
    public TextField txtPrice;
    public AnchorPane pane;

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String package_id = txtPacId.getText();
        String package_name= txtPacName.getText();
        String price = txtPrice.getText();

       Packages packages = new Packages(package_id,package_name,price);

        boolean isAdded =  PackageModel.addPackages(packages);
        if(isAdded){
            new Alert(Alert.AlertType.INFORMATION,"Package Added Successful").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Somthing was wrong").show();

        }
    }



    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            boolean isDelete =PackageModel.deletePackages(txtPacId.getText());
            if(isDelete){
                new Alert(Alert.AlertType.INFORMATION,"Package Delete Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){

        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtPacId.getText();
        String name = txtPacName.getText();
        String price = txtPrice.getText();


        Packages packages = new Packages(id,name,price);

        try {
            boolean isUpdate =PackageModel.updatePackages(packages);
            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"pa cupdate Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){

        }

    }

}