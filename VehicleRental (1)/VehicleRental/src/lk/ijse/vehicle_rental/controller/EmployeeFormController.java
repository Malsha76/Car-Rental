package lk.ijse.vehicle_rental.controller;
/**
 * @author:Malsha Ekanayake
 */
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.model.EmployeeModel;
import lk.ijse.vehicle_rental.to.Employee;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeFormController {
    public AnchorPane pane;
    public AnchorPane panec;
    public TextField txtEmpid;
    public TextField txtRole;
    public TextField txtAddre;
    public TextField txtContact;
    public TextField txtSalary;
    public TextField txtName;
    public TextField txtId;
    public TextField txtSearch;


    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtEmpid.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String contact = txtContact.getText();
        String address = txtAddre.getText();
        String salary = txtSalary.getText();

        Employee employee = new Employee(id, name, role, contact, address, salary);
        boolean isAdded = EmployeeModel.addEmployee(employee);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Added Successful").show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Employee not Added ").show();

        }



   /* public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);*/
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
           Employee employee = EmployeeModel.searchEmployee(txtEmpid.getText());
            if(employee!=null){
                txtName.setText(employee.getName());
                txtRole.setText(employee.getAddress());
                txtContact.setText(employee.getContact());
                txtAddre.setText(employee.getAddress());
                txtSalary.setText(employee.getSalary());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtEmpid.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String contact = txtContact.getText();
        String address = txtAddre.getText();
        String salary = txtSalary.getText();

       Employee employee = new Employee(id,name,role,contact,address,salary);

        try {
            boolean isUpdate = EmployeeModel.updateEmployee(employee);
            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"Employee update Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){

        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtEmpid.getText();
        System.out.println(id);
        try {
            boolean isDelete = EmployeeModel.deleteemployee(id);

            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Delete Successful").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Something Was Wrong").show();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }
}
