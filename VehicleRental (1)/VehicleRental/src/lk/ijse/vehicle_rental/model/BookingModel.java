package lk.ijse.vehicle_rental.model;
/**
 * @author:Malsha Ekanayake
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.vehicle_rental.to.Booking;
import lk.ijse.vehicle_rental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingModel {
    public static boolean addBook(Booking booking) {
        try {
            return CrudUtil.execute("insert into carrental.book (book_id, reg_id, book_date, return_date, cus_id) values (?,?,?,?,?)",
                    booking.getBook_id(),
                    booking.getReg_id(),
                    booking.getBook_date(),
                    booking.getReturn_date(),
                    booking.getCus_id());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING, e.toString()).show();

        }
        return false;
    }


    public static Booking searchBooking(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM book WHERE book_id = ?";

        ResultSet resultSet = CrudUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Booking(
                    resultSet.getString("book_id"),
                    resultSet.getString("reg_id"),
                    resultSet.getString("cus_id"),
                    resultSet.getString("book_date"),
                    resultSet.getString("return_date"));
        }
        return null;
    }

    public static String getAvalibility(String id) {
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT availability FROM vehicleDetail WHERE reg_id = ?", id);
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING, e.toString()).show();
        }
        return null;

    }

    public static ObservableList<Booking> searchAllBooking() throws SQLException, ClassNotFoundException {
        ObservableList<Booking> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM book";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()) {
            Booking booking = new Booking(
                    resultSet.getString("book_id"),
                    resultSet.getString("reg_id"),
                    resultSet.getString("cus_id"),
                    resultSet.getString("book_date"),
                    resultSet.getString("return_date")) ;

            list.add(booking);
        }
        return list;
    }

    public static boolean deleteBooking(String text) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE book_id = '"+text+"'";
        return CrudUtil.execute(sql);
    }
}

