package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake
 */
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.model.ManagevehicleModel;
import lk.ijse.vehicle_rental.to.Managevehicle;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class ManageVehicleFormController {

    public TextField txtRegid;
    public TextField txtModel;
    public TextField txtColour;
    public TextField txtInsur;
    public TextField txtTransmi;
    public TextField txtVehname;

    public TextField txtSearch;
    public TextField txtAvailability;
    public TableView<Managevehicle> tblVehicle;
    public TableColumn colRegId;
    public TableColumn colModel;
    public TableColumn colColour;
    public TableColumn colInsur;
    public TableColumn colVehname;
    public TableColumn colTrans;
    public TableColumn colAvalible;

    public void initialize() {
        colRegId.setCellValueFactory(new PropertyValueFactory<>("resigter_id"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colColour.setCellValueFactory(new PropertyValueFactory<>("colour"));
        colInsur.setCellValueFactory(new PropertyValueFactory<>("insurance"));
        colVehname.setCellValueFactory(new PropertyValueFactory<>("veh_name"));
        colAvalible.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colTrans.setCellValueFactory(new PropertyValueFactory<>("transmission"));

        lodeData();
    }

    public void lodeData() {
        try {
            ObservableList<Managevehicle> managevehicles = ManagevehicleModel.getVehiclDetails();
            tblVehicle.setItems(managevehicles);

        } catch (Exception ex) {
            new Alert(Alert.AlertType.WARNING, ex.toString()).show();
        }

    }


    @FXML
    private AnchorPane pane;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            Managevehicle managevehicle = ManagevehicleModel.searchVehicle(txtRegid.getText());
            System.out.println(managevehicle);
            if (managevehicle != null) {
                txtRegid.setText(managevehicle.getResigter_id());
                txtModel.setText(managevehicle.getModel());
                txtTransmi.setText(managevehicle.getTransmission());
                txtInsur.setText(managevehicle.getInsurance());
                txtVehname.setText(managevehicle.getVeh_name());
                txtColour.setText(managevehicle.getColour());
                txtAvailability.setText(managevehicle.getAvailability());
            }else{
                new Alert(Alert.AlertType.ERROR, "Wrong ID!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Customer Search Failed \n" + e).show();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String register_id = txtRegid.getText();
        String model = txtModel.getText();

        String colour = txtColour.getText();
        String veh_name = txtVehname.getText();
        String insurance = txtInsur.getText();
        String transmission = txtTransmi.getText();
        String avalibility = txtAvailability.getText();

        Managevehicle managevehicle2 = new Managevehicle(register_id, model, colour, avalibility, veh_name, insurance, transmission);

        boolean isAdded = ManagevehicleModel.addvehicledetail(managevehicle2);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "vehicle Added Successful").show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "vehicle not Added ").show();
        }
        lodeData();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDelete = ManagevehicleModel.deletevehicleDetail(txtRegid.getText());
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Vehicle Delete Successful").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Somthig Was Wrong").show();
            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.INFORMATION, ex.toString()).show();
        }
        lodeData();
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String reg_id = txtRegid.getText();
        String model = txtModel.getText();
        String colour = txtColour.getText();
        String veh_name = txtVehname.getText();
        String insurance = txtInsur.getText();
        String transmission = txtTransmi.getText();
        String avalibility = txtAvailability.getText();

        Managevehicle managevehicle = new Managevehicle(reg_id, model, colour, avalibility, veh_name, insurance, transmission);

        try {
            boolean isUpdate = ManagevehicleModel.updateManagevehicle(managevehicle);

            if (isUpdate) {
                new Alert(Alert.AlertType.INFORMATION, "Vehicle update Successful").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Somthig Was Wrong").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error\n"+e).show();
        }
        lodeData();
    }
}
