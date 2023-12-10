package lk.ijse.vehicle_rental.model;
/**
 * @author:Malsha Ekanayake
 */
import javafx.scene.control.Alert;
import lk.ijse.vehicle_rental.to.Payment;
import lk.ijse.vehicle_rental.util.CrudUtil;

import java.sql.SQLException;

public class PaymentModel {


    public static boolean addPayment(Payment payment) {
        try {
            return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?,?,?)",
                    payment.getId(),
                    payment.getDate(),
                    payment.getAdvance(),
                    payment.getPayment(),
                    payment.getCusID()
            );
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
        return false;
    }

    public static boolean deletePayment(String text) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM payment WHERE bill_id = '" + text + "'";
        return CrudUtil.execute(sql);
    }

    public static boolean updatePayment(Payment payment) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE payment SET  date  = ? ,advance= ? , fee = ?  cus_id = ? , WHERE bill_id = ? ";
        return CrudUtil.execute(sql,
                payment.getDate(),
                payment.getAdvance(),
                payment.getPayment(),
                payment.getCusID(),
                payment.getId());
    }
}

   /* public static boolean deletePayment(String text) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM payment WHERE bill_id = '"+id+"'";
        return CrudUtil.execute(sql);

    }*/


    /*public static boolean addPayment(String payment) {
        String sql = "INSERT INTO payment VALUES (?,?,?,?,?)";
        return CrudUtil.execute(sql,payment.getId(),payment.get(),customer.getAddress(),customer.getEmail(),customer.getContact());
    }
    }*/

