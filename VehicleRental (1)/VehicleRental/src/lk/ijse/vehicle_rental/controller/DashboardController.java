package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;

public class DashboardController {
    @FXML
    private AnchorPane pane;

    @FXML
    void bookingOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BOOKING, pane);
    }

    @FXML
    void customerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGE_CUSTOMER, pane);
    }

    @FXML
    void employeeMngOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGE_EMPLOYEE, pane);
    }

    @FXML
    void logoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    @FXML
    void paymentOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENT, pane);
    }

    @FXML
    void reportsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.REPORTS, pane);
    }

    @FXML
    void vehicalMngOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGE_VEHICLES, pane);
    }

    public void packagesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PACKAGES, pane);
    }
}
