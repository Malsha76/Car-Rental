package lk.ijse.vehicle_rental.model;
/**
 * @author:Malsha Ekanayake
 */
import lk.ijse.vehicle_rental.to.Packages;
import lk.ijse.vehicle_rental.util.CrudUtil;

import java.sql.SQLException;

public class PackageModel {
    public static boolean addPackages(Packages packages) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO package VALUES (?,?,?)";
        return CrudUtil.execute(sql, packages.getPackage_id(), packages.getPackage_name(), packages.getPrice());
    }

    public static boolean deletePackages(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM package WHERE pac_id = ?" ;
        return CrudUtil.execute(sql,id);
    }

    public static boolean updatePackages(Packages packages) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE package pac_id SET pac_name = ? , price  = ? WHERE pac_id = ?";
        return CrudUtil.execute(sql,
               packages.getPackage_name(),
                packages.getPrice(),
               packages.getPackage_id());

    }
}

