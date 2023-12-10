package lk.ijse.vehicle_rental.model;
/**
 * @author:Malsha Ekanayake
 */
import lk.ijse.vehicle_rental.to.Employee;
import lk.ijse.vehicle_rental.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql, employee.getId(), employee.getName(), employee.getRole(),
                employee.getContact(), employee.getAddress(), employee.getSalary());
    }


    public static boolean deleteemployee(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM employee WHERE em_id = ?", id);
    }

    public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET em_name = ? ,em_role  = ? , contact = ? , em_address = ?, salary = ? WHERE em_id = ?";
        return CrudUtil.execute(sql,
                employee.getName(),
                employee.getRole(),
                employee.getContact(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());
    }

    public static Employee searchEmployee(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE em_id = ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString("em_id"),
                    resultSet.getString("em_name"),
                    resultSet.getString("em_role"),
                    resultSet.getString("contact"),
                    resultSet.getString("em_address"),
                    resultSet.getString("salary"));
        }
        return null;
    }
}
