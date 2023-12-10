package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake

 */

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.db.DBConnection;
import lk.ijse.vehicle_rental.model.BookingModel;
import lk.ijse.vehicle_rental.model.ManagevehicleModel;
import lk.ijse.vehicle_rental.to.Booking;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookingFormController {
    public AnchorPane pane;
    public AnchorPane panec;
    public TextField txtBookId;

    public TextField txtPacId;
    public TextField txtPacName;
    public TextField txtPrice;
    public TextField txtBookId1;
    public TextField txtSearch;
    public TextField txtCustomerId;
    public TextField txtBdate;
    public TextField txtRetDate;
    public TextField txtRegID;
    public TextField txtAvailability;
    public TableView<Booking> tblBooking;
    public TableColumn colBID;
    public TableColumn colRegid;
    public TableColumn colCuSId;
    public TableColumn colBoId;
    public TableColumn colRetId;

    public void initialize() {
        colBID.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colRegid.setCellValueFactory(new PropertyValueFactory<>("reg_id"));
        colCuSId.setCellValueFactory(new PropertyValueFactory<>("cus_id"));
       colBoId.setCellValueFactory(new PropertyValueFactory<>("book_date"));
        colRetId.setCellValueFactory(new PropertyValueFactory<>("return_date"));

        txtRetDate.setText(LocalDate.now().toString());
        txtBdate.setText(LocalDate.now().toString());

        lodeBookingData();

    }
    public void lodeBookingData(){
        try {
            ObservableList<Booking> booking = BookingModel.searchAllBooking();
            tblBooking.setItems(booking);

        }catch (Exception ex){
            new Alert(Alert.AlertType.WARNING, ex.toString()).show();
        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String book_id = txtBookId.getText();
        String regID = txtRegID.getText();
        String cus_id = txtCustomerId.getText();
        String book_date = txtBdate.getText();
        String return_date = txtRetDate.getText();
        String avalible = txtAvailability.getText();


        if (avalible.equals("yes")) {
            if (!book_id.equals("")) {
                Booking booking = new Booking(book_id, regID, cus_id, book_date, return_date);

                // transaction
                Connection connection = DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);

                boolean isAdded = BookingModel.addBook(booking);
                boolean isNotAvailable = ManagevehicleModel.updateManagevehicleToNo(regID);

                if (isAdded && isNotAvailable) {
                    connection.commit();
                    new Alert(Alert.AlertType.INFORMATION, "booking Added Successful").show();
                } else {
                   connection.rollback();
                   new Alert(Alert.AlertType.INFORMATION, "booking not Added ").show();
                }
                connection.setAutoCommit(true);



            } else {
                new Alert(Alert.AlertType.WARNING, "Fill all data").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Already booked!").show();
        }
        lodeBookingData();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    /*public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDelete = BookingModel.deleteBooking(txtBookId.getText());
            if(isDelete){
                new Alert(Alert.AlertType.INFORMATION,"Booking Delete Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){
    }*/

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            boolean isDelete =BookingModel.deleteBooking(txtBookId.getText());
            if(isDelete){
                new Alert(Alert.AlertType.INFORMATION,"Booking Delete Successful").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Booking Delete Failed \nWrong id").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Booking Delete Failed \n"+e).show();


        }
        lodeBookingData();
    }

    public void btnSearchRIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtAvailability.setText(BookingModel.getAvalibility(txtRegID.getText()));
    }

    public void btnSearchBIDOnAction(ActionEvent actionEvent) {
        try {
            Booking book = BookingModel.searchBooking(txtBookId.getText());
            if (book != null) {
                txtBookId.setText(book.getBook_id());
                txtRegID.setText(book.getReg_id());
                txtCustomerId.setText(book.getCus_id());
                txtBdate.setText(book.getBook_date());
                txtRetDate.setText(book.getReturn_date());
                txtAvailability.setText(BookingModel.getAvalibility(txtRegID.getText()));
            }else {
                new Alert(Alert.AlertType.WARNING, "Wrong ID!").show();
            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.WARNING, ex.toString()).show();
        }
    }
}



