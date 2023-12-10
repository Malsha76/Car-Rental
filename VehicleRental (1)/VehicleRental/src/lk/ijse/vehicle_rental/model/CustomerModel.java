package lk.ijse.vehicle_rental.model;
/**
 * @author:Malsha Ekanayake
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.to.Customer;
import lk.ijse.vehicle_rental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public static boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?)";
        return CrudUtil.execute(sql,customer.getId(),customer.getName(),customer.getAddress(),customer.getEmail(),customer.getContact());
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE cus_id = '"+id+"'";
        return CrudUtil.execute(sql);
    }

    public static boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE customer SET cus_name = ? , address  = ? , email = ? , contact = ? WHERE cus_id = ?";
        return CrudUtil.execute(sql,
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getContact(),
                customer.getId());
    }

    public static Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer WHERE cus_id =?";
        ResultSet resultSet = CrudUtil.execute(sql,id);
        if(resultSet.next()){
            return new Customer(
                    resultSet.getString("cus_id"),
                    resultSet.getString("cus_name"),
                    resultSet.getString("address"),
                    resultSet.getString("email"),
                    resultSet.getString("contact"));
        }
        return null;
    }

    public static ObservableList<Customer> searchAllCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<Customer> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            Customer customer = new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
            list.add(customer);
        }
        return list;
    }
}
