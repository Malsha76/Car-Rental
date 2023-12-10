package lk.ijse.vehicle_rental.model;
/**
 * @author:Malsha Ekanayake
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.vehicle_rental.to.Managevehicle;
import lk.ijse.vehicle_rental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagevehicleModel {


    public static boolean addvehicledetail(Managevehicle managevehicle2) {
        try {
            //register_id, model, colour, avalibility, veh_name, insurance, transmission
            return CrudUtil.execute("INSERT INTO vehicledetail VALUES (?,?,?,?,?,?,?)",
                    managevehicle2.getResigter_id(),
                    managevehicle2.getModel(),
                    managevehicle2.getColour(),
                    managevehicle2.getAvailability(),
                    managevehicle2.getVeh_name(),
                    managevehicle2.getInsurance(),
                    managevehicle2.getTransmission());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
        return false;
    }

    public static boolean deletevehicleDetail(String text) {
        String sql = "DELETE FROM vehicledetail WHERE reg_id = '" + text + "'";
        try {
            return CrudUtil.execute(sql);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
        return false;
    }


    public static boolean updateManagevehicleToNo(String regID) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicleDetail SET availability = 'no' where reg_id = ?";
        return CrudUtil.execute(sql, regID);
    }

    public static boolean updateManagevehicleToYes(String regID) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicleDetail SET availability = 'yes' where reg_id = ?";
        return CrudUtil.execute(sql, regID);
    }

    public static boolean updateManagevehicle(Managevehicle managevehicle) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicleDetail SET model = ? , colour  = ? ,veh_name = ? ,availability = ?,insurance = ?, transmission = ? WHERE reg_id = ?";
        //register_id, model, colour, avalibility, veh_name, insurance, transmission
        return CrudUtil.execute(sql,
                managevehicle.getModel(),
                managevehicle.getColour(),
                managevehicle.getVeh_name(),
                managevehicle.getAvailability(),
                managevehicle.getInsurance(),
                managevehicle.getTransmission(),
                managevehicle.getResigter_id());
    }

    public static Managevehicle searchVehicle(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM vehicleDetail WHERE reg_id =?";
        ResultSet resultSet = CrudUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Managevehicle(
                    resultSet.getString("reg_id"),
                    resultSet.getString("model"),
                    resultSet.getString("colour"),
                    resultSet.getString("veh_name"),
                    resultSet.getString("availability"),
                    resultSet.getString("insurance"),
                    resultSet.getString("transmission")
            );
        }
        return null;
    }

    public static ObservableList<Managevehicle> getVehiclDetails() throws SQLException, ClassNotFoundException {
        ObservableList<Managevehicle> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM vehicledetail";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()) {
            Managevehicle managevehicle = new Managevehicle(
                    resultSet.getString("reg_id"),
                    resultSet.getString("model"),
                    resultSet.getString("colour"),
                    resultSet.getString("veh_name"),
                    resultSet.getString("availability"),
                    resultSet.getString("insurance"),
                    resultSet.getString("transmission"));

            list.add(managevehicle);
        }
        return list;
    }
}


