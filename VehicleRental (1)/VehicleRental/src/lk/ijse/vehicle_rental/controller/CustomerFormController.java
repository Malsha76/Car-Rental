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
import lk.ijse.vehicle_rental.model.CustomerModel;
import lk.ijse.vehicle_rental.to.Customer;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerFormController {
    public AnchorPane pane;
    public AnchorPane panec;
    public TextField txtId;
    public TextField txtemail;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtContact;
    public TableView tblCustomer;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public TableColumn colContact;


    public void initialize(){
        lodeCustomerData();
        setCellValueFactory();

    }


public void lodeCustomerData(){
    try {
        ObservableList<Customer> customer = CustomerModel.searchAllCustomer();
        tblCustomer.setItems(customer);

    }catch (Exception ex){
        new Alert(Alert.AlertType.WARNING,ex.toString()).show();
    }

}
        public void setCellValueFactory(){
             colID.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        }



    public void btnAddOnAction(ActionEvent actionEvent)  {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtemail.getText();
        String contact = txtContact.getText();

        Customer customer = new Customer(id,name,address,email,contact);

        try {
            boolean isAdded = CustomerModel.addCustomer(customer);
            if(isAdded){
                new Alert(Alert.AlertType.INFORMATION,"Customer Added Successful").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Customer Added Failed").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.WARNING,"Customer Added Failed \n"+e).show();
        }
        lodeCustomerData();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtemail.getText();
        String contact = txtContact.getText();

        Customer customer = new Customer(id,name,address,email,contact);

        try {
            boolean isUpdate = CustomerModel.updateCustomer(customer);
            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"Customer update Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Customer Update failed").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Customer Update Failed \n"+e).show();
        }
        lodeCustomerData();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            Customer customer = CustomerModel.searchCustomer(txtId.getText());
            if(customer!=null){
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtemail.setText(customer.getEmail());
                txtContact.setText(customer.getContact());
            }else{
                new Alert(Alert.AlertType.WARNING,"Invalid Id").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Customer Search Failed \n"+e).show();
        }
    }



    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,pane);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDelete =CustomerModel.deleteCustomer(txtId.getText());
            if(isDelete){
                new Alert(Alert.AlertType.INFORMATION,"Customer Delete Successful").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Customer Delete Failed \nWrong id").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Customer Delete Failed \n"+e).show();


        }
        lodeCustomerData();
    }
}
