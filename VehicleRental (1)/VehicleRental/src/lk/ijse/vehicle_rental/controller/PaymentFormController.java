package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake
 */
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.model.ManagevehicleModel;
import lk.ijse.vehicle_rental.model.PaymentModel;
import lk.ijse.vehicle_rental.to.Payment;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PaymentFormController {
    public AnchorPane pane;
    public TextField txtBill;
    public TextField txtDate;
    public TextField txtAdvance;
    public TextField txtTotal;
    public TextField txtRegID;
    public TextField txtCusID;

    public void initialize(){
        txtDate.setText(LocalDate.now().toString());

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtBill.getText();
        String date = txtDate.getText();
        String advance = txtAdvance.getText();
        String payment = txtTotal.getText();
        String cusID = txtCusID.getText();
        String regID = txtRegID.getText();


        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Payment payment1 = new Payment(id, date, advance, payment, cusID);
        boolean isAdded = PaymentModel.addPayment(payment1);
        boolean isAvailable = ManagevehicleModel.updateManagevehicleToYes(regID);

        if (isAdded && isAvailable) {
            connection.commit();
            new Alert(Alert.AlertType.INFORMATION, "Payment Added Successful").show();
        } else {
            connection.rollback();
            new Alert(Alert.AlertType.INFORMATION, "Payment not Added  ").show();
        }
        connection.setAutoCommit(true);
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDelete = PaymentModel.deletePayment(txtBill.getText());
            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "PAYMENT Delete Successful").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Somthig Was Wrong").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Somthig Was Wrong" + e).show();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtBill.getText();
        String date = txtDate.getText();
        String advance = txtAdvance.getText();
        String payment = txtTotal.getText();
        String cusID = txtCusID.getText();
        String regID = txtRegID.getText();


       Payment payment1 = new Payment(id,date,advance,payment,cusID);

        try {
            boolean isUpdate = PaymentModel.updatePayment(payment1);
            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"Payment update Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Payment Update failed").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Payment Update Failed \n"+e).show();
        }
        lodePaymentData();
    }

    private void lodePaymentData() {
    }


    public void btnSearchOnAction(ActionEvent actionEvent) {
    }
}