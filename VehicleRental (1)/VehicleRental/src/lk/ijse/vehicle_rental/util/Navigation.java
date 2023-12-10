package lk.ijse.vehicle_rental.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();

        switch (route) {
            case LOGIN:
                initUI("LoginForm.fxml");
                break;
            case BOOKING:
                initUI("BookingForm.fxml");
                break;
            case MANAGE_CUSTOMER:
                initUI("CustomerForm.fxml");
                break;
            case MANAGE_EMPLOYEE:
                initUI("EmployeeForm.fxml");
                break;
            case MANAGE_VEHICLES:
                initUI("ManageVehicleForm.fxml");
                break;
            case PAYMENT:
                initUI("PaymentForm.fxml");
                break;
            case REPORTS:
                initUI("Reports.fxml");
                break;
            case DASHBOARD:
                initUI("Dashboard.fxml");
                break;
            case PACKAGES:
                initUI("PackageForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/vehicle_rental/view/" + location)));
    }
}
